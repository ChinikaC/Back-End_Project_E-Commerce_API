package com.bnta.grechimomarketplace.controllers;
import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.ProductDTO;
import com.bnta.grechimomarketplace.models.ShoppingCartDTO;
import com.bnta.grechimomarketplace.services.BuyerService;
import com.bnta.grechimomarketplace.services.ProductService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private BuyerService buyerService;


    // return all products OR search for a specific product
    // 1 request param for a fuzzy match of the product category (EXTENSION)
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam Optional<String> searchQuery) {
        if (searchQuery.isPresent()) {
            List<ProductDTO> products = productService.getAllProductsContainingString(searchQuery.get());
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        } else {
            List<ProductDTO> products = productService.getAllProducts();
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        }
    }
    // TURN THIS INTO A DTO


}

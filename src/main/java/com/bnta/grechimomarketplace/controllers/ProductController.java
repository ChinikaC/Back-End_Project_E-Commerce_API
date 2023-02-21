package com.bnta.grechimomarketplace.controllers;
import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.ShoppingCartDTO;
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


    // return all products OR search for a specific product
    // 1 request param for a fuzzy match of the product category (EXTENSION)
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam Optional<String> searchQuery) {
        if (searchQuery.isPresent()) {
            List<Product> products = productService.getAllProductsContainingString(searchQuery.get());
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        } else {
            List<Product> products = productService.getAllProducts();
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        }
    }
    // TURN THIS INTO A DTO


    // addProductToCart
    // @PatchMapping --> add product from seller's inventory to cart so buyer can purchase it

    @PatchMapping(value = "/{productId}/buyer/{buyerId}")
    public ResponseEntity<ShoppingCartDTO> addProductToCart(@PathVariable Long productId,
                                                            @PathVariable Long buyerId) {
        return new ResponseEntity<>(productService.addProductToCart(productId, buyerId), HttpStatus.OK);
    }



    // viewCart() --> return shopping cart DTO






    // checkOut
    // @PostMapping
    // buyer cart to be transferred to new Order object
    // Order order = new Order();
    // order.getProducts.set(cart)
    // set cart to empty arraylist
    // transfer money from buyer card to sellerS CardsS
     //deduct quantity of items from seller

}

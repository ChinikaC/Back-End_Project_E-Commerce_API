package com.bnta.grechimomarketplace.controllers;

import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import com.bnta.grechimomarketplace.services.ProductService;
import com.bnta.grechimomarketplace.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;



    // register
    // would use the @PostMapping function to add a new user
    @PostMapping
    public ResponseEntity<Seller> register (@RequestBody Seller seller){
        Seller savedSeller = sellerService.register(seller);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

















    // Delete Seller
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteSellerAccount(@PathVariable Long id){
        sellerService.deleteAccount(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }



        // displayOrders (@GetMapping)
        // get all orders
        // use id to get the id for the specific seller who's orders we want to get


        // extension fulfilOrder
}

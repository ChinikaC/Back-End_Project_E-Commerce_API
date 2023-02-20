package com.bnta.grechimomarketplace.controllers;
import com.bnta.grechimomarketplace.services.ProductService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // createProduct (post mapping) --> to create & add a new product to the seller's inventory

    // addProductToCart
    // @PostMapping --> copy product from seller's inventory to cart so buyer can purchase it






}

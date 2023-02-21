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

    // searchProduct
    // @GetMapping --> add multiple request params in
    // 1 request param for a fuzzy match of the product name (derived query)
    // 1 request param for a fuzzy match of the product category (EXTENSION)




    // addProductToCart
    // @PostMapping --> add product from seller's inventory to cart so buyer can purchase it

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

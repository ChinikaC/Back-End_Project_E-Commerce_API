package com.bnta.grechimomarketplace.controllers;

import com.bnta.grechimomarketplace.models.ShoppingCartDTO;
import com.bnta.grechimomarketplace.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/buyers")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    // register
    // would use the @PostMapping function to add a new user



    // view all orders
    // @GetMapping to view all orders


    // update your details
    // use @PatchMapping (probably)
    //USE REQUESTBODY - make sure you can either update some or all fields
    // update email
    // update address
    // update card details


    // replace card
    // @PutMapping


    // addProductToCart --> move to buyer
    // @PatchMapping --> add product from seller's inventory to cart so buyer can purchase it

    @PatchMapping(value = "/{buyerId}/product/{productId}")
    public ResponseEntity<ShoppingCartDTO> addProductToCart(@PathVariable Long buyerId,
                                                            @PathVariable Long productId) {
        ShoppingCartDTO dto = buyerService.addProductToCart(buyerId, productId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }



    // viewCart() --> return shopping cart DTO --> move to buyer






    // checkOut
    // @PostMapping
    // buyer cart to be transferred to new Order object
    // Order order = new Order();
    // order.getProducts.set(cart)
    // set cart to empty arraylist
    // transfer money from buyer card to sellerS CardsS
    //deduct quantity of items from seller


}
package com.bnta.grechimomarketplace.controllers;


import com.bnta.grechimomarketplace.models.*;
import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.services.BuyerService;
import com.bnta.grechimomarketplace.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buyers")
public class BuyerController {

    @Autowired
    BuyerService buyerService;
    OrderService orderService;

    // register
    // would use the @PostMapping function to add a new user

    @PostMapping
    public ResponseEntity<Buyer> addNewBuyer (@RequestBody Buyer buyer){
        Buyer savedBuyer = buyerService.addNewBuyer(buyer);
        return new ResponseEntity<>(buyer, HttpStatus.CREATED);
    }

    // view all orders
    // @GetMapping to view all orders

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    // update your details
    // use @PatchMapping (probably)
    //USE REQUESTBODY - make sure you can either update some or all fields
    // update email
    // update address
    // update card details


    // replace card
    // @PutMapping
    @PutMapping(value = "/{buyerId}")
    public ResponseEntity<BankCard> replaceBankCard(@PathVariable Long buyerId, @RequestBody BankCard newBankCard ){
        Buyer buyer = buyerService.getBuyerById(buyerId);
        buyer.setCard(newBankCard);
        return new ResponseEntity<>(buyer.getCard(), HttpStatus.CREATED);
    }




    @PatchMapping(value = "/{buyerId}/product/{productId}")
    public ResponseEntity<ShoppingCartDTO> addProductToCart(@PathVariable Long buyerId,
                                                            @PathVariable Long productId) {
        ShoppingCartDTO dto = buyerService.addProductToCart(buyerId, productId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/{buyerId}/cart")
    public ResponseEntity<ShoppingCartDTO> viewCart(@PathVariable Long buyerId) {
        return new ResponseEntity<>(buyerService.getCart(buyerId), HttpStatus.OK);
    }

    @PostMapping(value = "/{buyerId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long buyerId,
                                            @RequestParam String address) {
        return new ResponseEntity<>(buyerService.placeOrder(buyerId, address), HttpStatus.OK);
    }

}
package com.bnta.grechimomarketplace.controllers;


import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.models.Buyer;
import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.models.ShoppingCartDTO;
import com.bnta.grechimomarketplace.services.BuyerService;
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

    // register
    // would use the @PostMapping function to add a new user

    @PostMapping
    public ResponseEntity<Buyer> addNewBuyer (@RequestBody Buyer buyer){
        Buyer savedBuyer = buyerService.addNewBuyer(buyer);
        return new ResponseEntity<>(buyer, HttpStatus.CREATED);
    }

    // view all orders
    // @GetMapping to view all orders

//    @GetMapping
//    public ResponseEntity<List<Order>> getAllOrders(){
//        List<Order> orders = orderService.getAllOrders();
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }




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

    @GetMapping(value = "/{buyerId}/cart")
    public ResponseEntity<ShoppingCartDTO> viewCart(@PathVariable Long buyerId) {
        return new ResponseEntity<>(buyerService.getCart(buyerId), HttpStatus.OK);
    }

    // checkOut
    // @PostMapping
    // buyer cart to be transferred to new Order object
    // Order order = new Order();
    // order.getProducts.set(cart)
    // set cart to empty arraylist
    // transfer money from buyer card to sellerS CardsS
    //deduct quantity of items from seller

    @PostMapping(value = "/{buyerId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long buyerId,
                                            @RequestParam String address) {
        return new ResponseEntity<>(buyerService.placeOrder(buyerId, address), HttpStatus.OK);
    }

}
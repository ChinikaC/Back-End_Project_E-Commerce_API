package com.bnta.grechimomarketplace.controllers;

import com.bnta.grechimomarketplace.models.Buyer;
import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.models.OrderDTO;
import com.bnta.grechimomarketplace.models.OrderRequest;
import com.bnta.grechimomarketplace.repositories.OrderRepository;
import com.bnta.grechimomarketplace.services.BuyerService;
import com.bnta.grechimomarketplace.services.OrderService;
import com.bnta.grechimomarketplace.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    SellerService sellerService;


    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable long orderId){
        Optional<Order> order = orderService.getOrderById(orderId);
        if (order.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(orderService.generateorderDTO(order.get()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders(@RequestParam Optional<Long> buyerId,
                                                    @RequestParam Optional<Long> sellerId) {
        if (buyerId.isPresent()) {
            if (buyerService.getBuyerById(buyerId.get()).isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(orderService.getOrdersByBuyer(buyerId.get()), HttpStatus.OK);
        }
        if (sellerId.isPresent()) {
            if (sellerService.getSellerById(sellerId.get()).isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(orderService.getOrdersBySeller(sellerId.get()), HttpStatus.OK);
        } else {
            if (orderService.getAllOrders().isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderRequest orderRequest) {
        Optional<Buyer> buyer = buyerService.getBuyerById(orderRequest.getBuyerId());
        if (buyer.isEmpty()) return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        if (buyer.get().getCart().isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (buyer.get().getCard().getAccountBalance() < buyer.get().getCartTotalValue()) return new ResponseEntity<>(HttpStatus.PAYMENT_REQUIRED);
        return new ResponseEntity<>(orderService.placeOrder(orderRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity deleteOrderById(@PathVariable long orderId){
        if(orderService.getOrderById(orderId).isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        orderService.deleteOrderById(orderId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }



}

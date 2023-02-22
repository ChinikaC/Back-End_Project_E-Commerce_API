package com.bnta.grechimomarketplace.controllers;

import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.models.OrderDTO;
import com.bnta.grechimomarketplace.repositories.OrderRepository;
import com.bnta.grechimomarketplace.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/buyers/{buyerId}")
    public ResponseEntity<List<OrderDTO>> getOrdersRelevantToBuyer(@PathVariable long buyerId){
        return new ResponseEntity<>(orderService.getOrdersByBuyer(buyerId), HttpStatus.OK);
    }

    @GetMapping(value = "/sellers/{sellerId}")
    public ResponseEntity<List<OrderDTO>> getOrdersRelevantToSeller(@PathVariable long sellerId) {
        return new ResponseEntity<>(orderService.getOrdersBySeller(sellerId), HttpStatus.OK);
    }

}

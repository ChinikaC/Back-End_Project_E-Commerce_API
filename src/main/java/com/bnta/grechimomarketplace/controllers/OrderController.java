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
    public ResponseEntity<List<OrderDTO>> getAllOrders(@PathVariable long buyerId){
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/sellers/{sellerId}")
    public List<OrderDTO> getOrdersRelevantToSeller(@PathVariable long sellerId) {
        return orderService.getOrderBySeller(sellerId);
    }

}

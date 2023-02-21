package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public List<Order> getAllOrders() { return orderRepository.findAll();}

    public void distributeOrders() {
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {

        }
    }
}

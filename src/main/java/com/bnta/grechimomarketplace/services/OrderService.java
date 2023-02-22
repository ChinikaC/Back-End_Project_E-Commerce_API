package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.models.OrderDTO;
import com.bnta.grechimomarketplace.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public List<OrderDTO> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orderList) {
            orderDTOList.add(new OrderDTO(order.getId(),order.getOrderValue(),order.getAddress(),order.getOrderProductDTOs(), order.getBuyer().getName(),order.getBuyer().getId(), order.getTimestamp()));
        }
        return orderDTOList;
    }

    public List<OrderDTO> getOrdersBySeller(long sellerId) {
        List<Order> orderList = orderRepository.findByProducts_Seller_Id(sellerId);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orderList) {
            orderDTOList.add(new OrderDTO(order.getId(),order.getOrderValue(),order.getAddress(),order.getOrderProductDTOs(), order.getBuyer().getName(),order.getBuyer().getId(), order.getTimestamp()));
        }
        return orderDTOList;
    }

    public List<OrderDTO> getOrdersByBuyer(long buyerId) {
        List<Order> orderList = orderRepository.findByBuyerId(buyerId);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orderList) {
            orderDTOList.add(new OrderDTO(order.getId(),order.getOrderValue(),order.getAddress(),order.getOrderProductDTOs(), order.getBuyer().getName(),order.getBuyer().getId(), order.getTimestamp()));
        }
        return orderDTOList;
    }

    public OrderDTO generateorderDTO(Order order) {
        return new OrderDTO(order.getId(),order.getOrderValue(),order.getAddress(),order.getOrderProductDTOs(), order.getBuyer().getName(),order.getBuyer().getId(), order.getTimestamp());
    }

//    public void distributeOrders() {
//        List<Order> orders = orderRepository.findAll();
//        for (Order order : orders) {
//
//        }
//    }
}

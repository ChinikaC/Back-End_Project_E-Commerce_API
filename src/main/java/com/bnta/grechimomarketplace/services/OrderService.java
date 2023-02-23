package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.*;
import com.bnta.grechimomarketplace.repositories.BuyerRepository;
import com.bnta.grechimomarketplace.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BuyerRepository buyerRepository;

    public List<OrderDTO> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orderList) {
            orderDTOList.add(new OrderDTO(order.getId(),order.getOrderValue(),order.getAddress(),order.getOrderProductDTOs(), order.getBuyer().getName(),order.getBuyer().getId(), order.getTimestamp()));
        }
        return orderDTOList;
    }

    public Optional<Order> getOrderById(long orderId){
        return orderRepository.findById(orderId);
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

    public OrderDTO generateOrderDTO(Order order) {
        return new OrderDTO(order.getId(),order.getOrderValue(),order.getAddress(),order.getOrderProductDTOs(), order.getBuyer().getName(),order.getBuyer().getId(), order.getTimestamp());
    }

    public OrderDTO placeOrder(OrderRequest orderRequest) {
        Optional<Buyer> buyer = buyerRepository.findById(orderRequest.getBuyerId());
        List<Product> buyerCart = buyer.get().getCart();
        BankCard buyerCard = buyer.get().getCard();
        for (Product product : buyerCart) {
            double productValue = product.getPrice();
            BankCard sellerCard = product.getSeller().getCard();
            buyerCard.reduceMoney(productValue);
            sellerCard.addMoney(productValue);
            product.decrementStock();
        }
        Order order = new Order(buyer.get(), orderRequest.getDeliveryAddress());
        List<Product> buyerCartCopy = new ArrayList<>(buyerCart);
        // had to create a copy of the buyer cart as I was getting an error when trying to persist
        order.setProducts(buyerCartCopy);
        buyer.get().emptyCart();
        orderRepository.save(order);
        return generateOrderDTO(order);
    }

    public void deleteOrderById(long orderId){
        orderRepository.deleteById(orderId);
    }


}

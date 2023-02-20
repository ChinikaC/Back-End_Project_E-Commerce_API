package com.bnta.grechimomarketplace.components;

import com.bnta.grechimomarketplace.models.Buyer;
import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.repositories.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    GCMBRepository gcmbRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Load 10 Buyers
        for (long i = 1; i <= 10; i++) {
            Buyer buyer = new Buyer(i, "Buyer " + i, "buyer" + i + "@bnta.com", "password" + i, 1000, new ArrayList<>());
            buyerRepository.save(buyer);
        }

        // Load 10 Orders
        for (long i = 1; i <= 10; i++) {
            Buyer buyer = buyerRepository.findById(i).get();
            Order order = new Order(i, i * 100, "Address " + i, buyer);
            orderRepository.save(order);
        }

        // Load 100 Products
        for (long i = 1; i <= 100; i++) {
            Seller seller = new Seller(i, 1000, "Seller " + i, "seller" + i + "@bnta.com", "password" + i, new ArrayList<>());
            sellerRepository.save(seller);
            Product product = new Product(i, "Product " + i, i * 100, "Description " + i, seller, true, false);
            productRepository.save(product);
            seller.getProducts().add(product);
            sellerRepository.save(seller);
        }

        // Load 10 Sellers
        for (long i = 1; i <= 10; i++) {
            Seller seller = new Seller(i, 1000, "Seller " + i, "seller" + i + "@bnta.com", "password" + i, new ArrayList<>());
            sellerRepository.save(seller);
        }

    }

}

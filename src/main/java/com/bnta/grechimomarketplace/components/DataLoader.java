package com.bnta.grechimomarketplace.components;

import com.bnta.grechimomarketplace.models.*;
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

    @Autowired
    BankCardRepository bankCardRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Load 10 Buyers
        for (long i = 1; i <= 10; i++) {
            BankCard card = new BankCard(1000l);
            bankCardRepository.save(card);
            Buyer buyer = new Buyer("Buyer " + i, "buyer" + i + "@bnta.com", i + " Fake Street", "password" + i, card, new ArrayList<>());
            card.setAccountName(buyer.getName());
            bankCardRepository.save(card);
            buyerRepository.save(buyer);
        }

        // Load 10 Products
        for (long i = 1; i <= 10; i++) {
            BankCard card = new BankCard(1000l);
            Seller seller = new Seller("Seller " + i, card, "seller" + i + "@bnta.com", i + " Fake Street", "password" + i, new ArrayList<>());
            card.setAccountName(seller.getName());
            bankCardRepository.save(card);
            sellerRepository.save(seller);
            Product product = new Product("Product " + i, i * 100, "Description " + i, seller, true, false);
            productRepository.save(product);
            seller.getProducts().add(product);
            sellerRepository.save(seller);
        }

        // Load 10 Orders
        for (long i = 1; i <= 10; i++) {
            Buyer buyer = buyerRepository.findById(i).get();
            Order order = new Order(buyer, i + " Fake Street, Fake City");
            orderRepository.save(order);
        }

        // Add Products to Orders
        for (long i = 1; i <= 10; i += 2) {
            Product product = productRepository.findById(i).get();
            Product product2 = productRepository.findById(i+1).get();
            Order order = orderRepository.findById(i).get();
            order.getProducts().add(product);
            order.getProducts().add(product2);
            orderRepository.save(order);
        }
        

        GCMBMarketplace gcmbMarketplace = new GCMBMarketplace(10000000, "5th floor, 80 Middlesex St, London E1 7EZ");
        gcmbRepository.save(gcmbMarketplace);

    }

}

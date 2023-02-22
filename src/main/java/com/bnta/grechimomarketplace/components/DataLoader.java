package com.bnta.grechimomarketplace.components;

import com.bnta.grechimomarketplace.models.*;
import com.bnta.grechimomarketplace.repositories.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

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

        String[] buyerNames = {"Aya", "Chinika", "Diana", "Mati", "Greg", "Hansine", "James", "Leah", "Mo", "Ramiro", "Ryder", "Samra", "Thinesan", "Wilson", "Xixian"};
        String[] sellerNames = {"Colin", "Richard", "Zsolt", "Ed", "Anna", "Phil", "Joe", "Lewis", "Eoan", "Iain"};

        // Load 10 Buyers
        for (int i = 0; i < buyerNames.length; i++) {
            BankCard card = new BankCard(10000l);
            bankCardRepository.save(card);
            Buyer buyer = new Buyer(buyerNames[i], buyerNames[i] + "@bnta.com", (i + 1) + " Fake Street", "password" + (i + 1), card);
            card.setAccountName(buyer.getName());
            bankCardRepository.save(card);
            buyerRepository.save(buyer);
        }

        String[] products = {
                "Aquarium", "Bouncy Castle", "Candlestick Holder", "Disco Ball", "Electric Kettle",
                "Fidget Spinner", "Gumball Machine", "Hand Sanitizer", "Infinity Mirror", "Juggling Balls",
                "Kaleidoscope", "Lava Lamp", "Mousetrap", "Nerf Gun", "Oil Diffuser",
                "Pencil Sharpener", "Quadcopter", "Rubik's Cube", "Soda Maker", "Treadmill",
                "Ukulele", "Virtual Reality Headset", "Waterproof Camera", "Xylophone", "Yo-yo",
                "Zamboni", "Air Fryer", "Blender", "Crockpot", "Dehydrator", "BNTAPhone"};

        String[] productDescriptions = {
                "Underwater excitement for your home!",
                "Jump into fun with this castle!",
                "Unleash your inner detective.",
                "Add some groove to your party.",
                "Boils water faster than a cheetah!",
                "Spin your way to relaxation.",
                "Taste the rainbow of flavors!",
                "Kills 99.9% of germs!",
                "Step into infinity.",
                "Become the master of juggling.",
                "See the world in a new way.",
                "Brings groovy vibes to your room.",
                "Catches those pesky critters!",
                "Dominate your next nerf battle.",
                "Create an oasis of relaxation.",
                "Keeps your pencils sharp like your wit!",
                "Unleash your inner pilot!",
                "Twist and turn to solve the puzzle.",
                "Fizzes up your drinks in seconds!",
                "Never miss a workout again!",
                "Strum your way to happiness.",
                "Experience a new reality.",
                "Capture memories with ease!",
                "Drum up some fun!",
                "Up and down and all around.",
                "The healthy way to fry.",
                "Blend up a storm!",
                "Slow cook like a pro.",
                "Dehydrate your way to deliciousness!",
                "Better than the iPhone."
        };

        // Load 30 Products & 10 Sellers
        for (int i = 0; i < sellerNames.length; i++) {
            BankCard card = new BankCard(1000l);
            Seller seller = new Seller(sellerNames[i], card, sellerNames[i] + "@bnta.com", "5th floor, " + (i+1) + " Middlesex St, London E1 7EZ", "password" + (i + 1), new ArrayList<>());
            card.setAccountName(seller.getName());
            bankCardRepository.save(card);
            sellerRepository.save(seller);
            for (int j = i * 3; j < (i + 1) * 3; j++) {
                Product product = new Product(products[j], (long) (Math.random() * 5000) + 1, productDescriptions[j], seller, (long) (Math.random() * 100) + 1, true, false);
                productRepository.save(product);
                seller.getProducts().add(product);
            }
            sellerRepository.save(seller);
        }


        // Create 10 Orders
        for (long i = 1; i <= buyerNames.length; i++) {
            Buyer buyer = buyerRepository.findById(i).get();
            Order order = new Order(buyer, i + " Mum's House, Fake City");
            orderRepository.save(order);
        }

        // Add Products to Orders
        for (long i = 0; i < buyerNames.length; i++) {
            for (long j = (i * 2); j < (i + 1) * 2; j++) {
                if (j < 1 || j > 30) continue;
                Product product = productRepository.findById(j).get();
                Order order = orderRepository.findById(i+1).get();
                order.getProducts().add(product);
                orderRepository.save(order);
            }
        }


        GCMBMarketplace gcmbMarketplace = new GCMBMarketplace(10000000, "5th floor, 80 Middlesex St, London E1 7EZ");
        gcmbRepository.save(gcmbMarketplace);

    }

}

package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.Buyer;
import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.ShoppingCartDTO;
import com.bnta.grechimomarketplace.repositories.BuyerRepository;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class BuyerService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BuyerRepository buyerRepository;

    public ShoppingCartDTO addProductToCart(long buyerId, long productId) {
        Product product = productRepository.findById(productId).get();
        Buyer buyer = buyerRepository.findById(buyerId).get();
        buyer.getCart().add(product);
        return new ShoppingCartDTO(buyer.getCart(), buyer.getCartTotalValue(), buyer.getCart().size());
    }
}

package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.*;
import com.bnta.grechimomarketplace.repositories.BuyerRepository;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import com.bnta.grechimomarketplace.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


@Autowired
ProductRepository productRepository;

@Autowired
BuyerRepository buyerRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsContainingString(String string) {
        return productRepository.findByNameContainingIgnoreCase(string);
    }

    public ShoppingCartDTO addProductToCart(long productId, long buyerId) {
        Product product = productRepository.findById(productId).get();
        Buyer buyer = buyerRepository.findById(buyerId).get();
        buyer.getCart().add(product);
        return new ShoppingCartDTO(buyer.getCart(), buyer.getCartTotalValue(), buyer.getCart().size());
    }

}

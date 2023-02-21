package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import com.bnta.grechimomarketplace.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    ProductRepository productRepository;

   // Register
    public Seller addNewSeller(Seller seller){
        sellerRepository.save(seller);
        return seller;
    }

    // AddProductToSellersInventory
    public Seller addProductToSellersInventory(long sellerId, long productId){
        Seller seller = sellerRepository.findById(sellerId).get();
        Product product = productRepository.findById(productId).get();
        List<Product> products = seller.getProducts();
        products.add(product);
        sellerRepository.save(seller);
        return seller;

    }

}

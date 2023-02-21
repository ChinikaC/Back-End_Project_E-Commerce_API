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

    public Seller register (Seller seller){
        sellerRepository.save(seller);
        return seller;
    }


//    public Product deleteProductById(long id){
//        sellerRepository.deleteById(id);
//
//    }























    public void deleteAccount(Long id){
        sellerRepository.deleteById(id);

    }

    }



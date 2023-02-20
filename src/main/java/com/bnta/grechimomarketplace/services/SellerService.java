package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller addNewSeller(Seller seller){
        sellerRepository.save(seller);
        return seller;
    }
}

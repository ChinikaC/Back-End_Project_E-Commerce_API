package com.bnta.grechimomarketplace.services;


import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.models.SellerDTO;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import com.bnta.grechimomarketplace.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<SellerDTO> getAllSellers(){
        List<Seller> sellers = sellerRepository.findAll();
        return generateSellerDTOs(sellers);
    }

    public Optional<Seller> getSellerById(long sellerId){
        Optional <Seller> seller = sellerRepository.findById(sellerId);
        return seller;
    } //admin

    public SellerDTO findSellerDTOById(long sellerId){
        Seller seller = sellerRepository.findById(sellerId).get();
        return generateSellerDTO(seller);
    }

    public SellerDTO generateSellerDTO(Seller seller){
        return new SellerDTO(seller.getId(), seller.getName(), seller.getEmail(),
                seller.getAddress(), seller.getSellerProductDTOs());
    }

    public List<SellerDTO> generateSellerDTOs(List<Seller> sellers){
        List<SellerDTO> sellerDTOs = new ArrayList<>();
        for (Seller seller : sellers) {
            sellerDTOs.add(new SellerDTO(seller.getId(), seller.getName(), seller.getEmail(),
                    seller.getAddress(), seller.getSellerProductDTOs()));
        }
        return sellerDTOs;
    }

    public Seller updateSeller(Seller updateSellerDetails){
        Optional<Seller> updateSeller = sellerRepository.findById(updateSellerDetails.getId());

        if(updateSeller.isPresent()){
            Seller updateDetails = updateSeller.get();
            if(updateSellerDetails.getName() != null) updateDetails.setName(updateSellerDetails.getName());
            if(updateSellerDetails.getAddress() != null) updateDetails.setAddress(updateSellerDetails.getAddress());
            if(updateSellerDetails.getCard() != null) updateDetails.setCard(updateSellerDetails.getCard());
            if (updateSellerDetails.getEmail() != null) updateDetails.setEmail(updateSellerDetails.getEmail());
            if (updateSellerDetails.getPassword() != null) updateDetails.setPassword(updateSellerDetails.getPassword());

            return sellerRepository.save(updateDetails);
        }
        return null;
    }

    public void deleteAccount(Long id){
        List <Product> products = productRepository.findBySellerId(id);
        for (Product product : products) {
            productRepository.delete(product);
        }
        sellerRepository.deleteById(id);
    }

}



package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import com.bnta.grechimomarketplace.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Seller> findAllSellers(){
        return sellerRepository.findAll();
    }

    public Seller getSellerById(long id){
        return sellerRepository.findById(id).get();
    }

    public Seller updateSeller(Seller updateSellerDetails){
        Optional<Seller> updateSeller = sellerRepository.findById(updateSellerDetails.getId());

        if(updateSeller.isPresent()){
            Seller updateDetails = updateSeller.get();
            if(updateSellerDetails.getName() != null) {
                updateDetails.setName(updateSellerDetails.getName());
            } if(updateSellerDetails.getAddress() != null){
                updateDetails.setAddress(updateSellerDetails.getAddress());
            } if(updateSellerDetails.getCard() != null){
                updateDetails.setCard(updateSellerDetails.getCard());
            } if (updateSellerDetails.getEmail() != null){
                updateDetails.setEmail(updateSellerDetails.getEmail());
            } if (updateSellerDetails.getPassword() != null){
                updateDetails.setPassword(updateSellerDetails.getPassword()); };
//             if (updateSellerDetails.getProducts() != null){
//                updateSellerDetails.setProducts(updateSellerDetails.getProducts());
//            } // DO I NEED TO INCLUDE PRODUCTS??
            return sellerRepository.save(updateDetails);
        }
        return null;
    }

    public void deleteAccount(Long id){
        sellerRepository.deleteById(id);

    }




}



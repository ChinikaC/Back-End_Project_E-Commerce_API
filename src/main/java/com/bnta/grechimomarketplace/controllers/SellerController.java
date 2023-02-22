package com.bnta.grechimomarketplace.controllers;

import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.models.SellerDTO;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import com.bnta.grechimomarketplace.services.ProductService;
import com.bnta.grechimomarketplace.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;


    @GetMapping
    public ResponseEntity<List<SellerDTO>> getAllSellers(){
        return new ResponseEntity(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SellerDTO> getSellerById(@PathVariable Long id){
        SellerDTO seller = sellerService.getSellerById(id);
        return new ResponseEntity(seller, seller != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    } // Find out why the not_found isn't working

    // add in sellers/id/admin

    @PostMapping
    public ResponseEntity<Seller> register (@RequestBody Seller seller){
        Seller savedSeller = sellerService.register(seller);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    // Update user details
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller seller){
        seller.setId(id);
        Seller updatedSeller = sellerService.updateSeller(seller);
        return new ResponseEntity<>(updatedSeller, updatedSeller != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteSellerAccount(@PathVariable Long id){
        sellerService.deleteAccount(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


}

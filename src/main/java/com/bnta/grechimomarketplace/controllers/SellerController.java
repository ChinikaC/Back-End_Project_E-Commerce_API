package com.bnta.grechimomarketplace.controllers;

import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.Seller;
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


    // register
    // would use the @PostMapping function to add a new user
    @PostMapping
    public ResponseEntity<Seller> register (@RequestBody Seller seller){
        Seller savedSeller = sellerService.register(seller);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Seller>> getAllSellers(){
        return new ResponseEntity(sellerService.findAllSellers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id){
        Seller seller = sellerService.getSellerById(id);
        return new ResponseEntity(seller, seller != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    } // Find out why the not_found isn't working

    // Update user details
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller seller){
        seller.setId(id);
        Seller updatedSeller = sellerService.updateSeller(seller);
        return new ResponseEntity<>(updatedSeller, updatedSeller != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }




        // displayOrders (@GetMapping)
        // get all orders
        // use id to get the id for the specific seller who's orders we want to get


        // extension fulfilOrder
}

package com.bnta.grechimomarketplace.controllers;

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
        List<SellerDTO> sellers = sellerService.getAllSellers();
        if(sellers.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SellerDTO> getSellerById(@PathVariable Long id){
        Optional<Seller> seller = sellerService.getSellerById(id);
        if (seller.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity(sellerService.getSellerDTOById(id), HttpStatus.OK);
    } // Find out why the not_found isn't working
    

    // add in sellers/id/admin

    @PostMapping
    public ResponseEntity<Seller> register (@RequestBody Seller seller){
        Seller savedSeller = sellerService.register(seller);
        if (seller.getCard() == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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






    // displayOrders (@GetMapping)
        // get all orders
        // use id to get the id for the specific seller who's orders we want to get


        // extension fulfilOrder
}

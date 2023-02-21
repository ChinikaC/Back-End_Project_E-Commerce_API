package com.bnta.grechimomarketplace.controllers;

import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.Seller;
import com.bnta.grechimomarketplace.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;


    // register
    // would use the @PostMapping function to add a new user
    @PostMapping
    public ResponseEntity<Seller> addNewSeller (@RequestBody Seller seller){
        Seller savedSeller = sellerService.addNewSeller(seller);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    // createProduct (post mapping) --> to create & add a new product to the seller's inventory


//    @PatchMapping(value = "/{id}")
//    public ResponseEntity<Seller> addProductToSellersInventory( @RequestBody Product product, @PathVariable long id){
//        long sellerId = product.getId();
//        Seller updatedInventory = sellerService.addProductToSellersInventory(id, product);
//        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
//    }

//    @PatchMapping(value = "/{id}")
//    public ResponseEntity<Seller> addProductToSellersInventory(@PathVariable long id,
//                                                               @RequestBody Product product){
//        Seller seller = sellerService.addProductToSellersInventory(id, product);
//        return new ResponseEntity<>(seller, HttpStatus.OK);
//    }









    // /seller/list/{id}
    // listProduct (@patchmapping)
    // Changing product listing from false to true
    //Have a @requestparam which will take in true or false depending on whether it is listed or not

    //deleteProduct (@DeleteMapping)

    // /seller/update/{id}
    // updateProduct (@PatchMapping) --> multiple optional requestparams OR requestBody
    // (BUT requestBody would have to allow both updating just one variable or all variables at once)

    // displayOrders (@GetMapping)
    // get all orders
    // use id to get the id for the specific seller who's orders we want to get



    // extension fulfilOrder



}

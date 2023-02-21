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

    // createProduct (post mapping) --> to create & add a new product to the seller's inventory

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Product> addProductToSellersInventory(@PathVariable long id,
                                                               @RequestBody Product product){
        sellerService.addProductToSellersInventory(id, product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // /seller/list/{id}
    // listProduct (@patchmapping)
    // Changing product listing from false to true
    //Have a @requestparam which will take in true or false depending on whether it is listed or not
    // have a delist and list link


    @PatchMapping(value = "product/{productId}/list")
    public ResponseEntity<Product> changingListingToTrue(@PathVariable long productId){
        Product product = sellerService.getProductById(productId);
        product.setListed(true);
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PatchMapping(value = "product/{productId}/delist")
    public ResponseEntity<Product> changingListingToFalse(@PathVariable long productId){
        Product product = sellerService.getProductById(productId);
        product.setListed(false);
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

        //deleteProduct (@DeleteMapping)


        // /seller/update/{id}
        // updateProduct (@PatchMapping) --> multiple optional requestparams OR requestBody
        // (BUT requestBody would have to allow both updating just one variable or all variables at once)

        // displayOrders (@GetMapping)
        // get all orders
        // use id to get the id for the specific seller who's orders we want to get


        // extension fulfilOrder
}

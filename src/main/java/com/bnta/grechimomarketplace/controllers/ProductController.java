package com.bnta.grechimomarketplace.controllers;
import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.ProductDTO;
import com.bnta.grechimomarketplace.models.ShoppingCartDTO;
import com.bnta.grechimomarketplace.services.BuyerService;
import com.bnta.grechimomarketplace.services.ProductService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private BuyerService buyerService;

    // 1 request param for a fuzzy match of the product category (EXTENSION)
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam Optional<String> searchQuery) {
        if (searchQuery.isPresent()) {
            List<ProductDTO> products = productService.getAllProductsContainingString(searchQuery.get());
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        } else {
            List<ProductDTO> products = productService.getAllProducts();
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        }
    }

    @PostMapping
    public ResponseEntity<Product> addNewProductToSellersInventory(@RequestParam long sellerId,
                                                                   @RequestBody Product product){
        productService.addNewProductToSellersInventory(sellerId, product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{productId}")
    public ResponseEntity<Product> changeListing(@PathVariable long productId,
                                                         @RequestParam boolean isListed){
        Product product = productService.updateListing(productId, isListed);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PatchMapping(value = "/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable long productId,
                                                 @RequestParam Optional<String> name,
                                                 @RequestParam Optional<Long> price,
                                                 @RequestParam Optional<String> description,
                                                 @RequestParam Optional<Boolean> listed,
                                                 @RequestParam Optional<Boolean> fulfilled,
                                                 @RequestParam Optional<Long> stock) {
        Product existingProduct = productService.getProductById(productId);
        if (existingProduct == null) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if (name.isPresent()) existingProduct.setName(name.get());
        if (price.isPresent()) existingProduct.setPrice(price.get());
        if (description.isPresent()) existingProduct.setDescription(description.get());
        if (listed.isPresent()) existingProduct.setListed(listed.get());
        if (fulfilled.isPresent()) existingProduct.setFulfilled(fulfilled.get());
        if (stock.isPresent()) existingProduct.setStock(stock.get());

        productService.saveProduct(existingProduct);
        return new ResponseEntity<>(existingProduct, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}

package com.bnta.grechimomarketplace.controllers;


import com.bnta.grechimomarketplace.models.*;
import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.repositories.BankCardRepository;
import com.bnta.grechimomarketplace.services.BuyerService;
import com.bnta.grechimomarketplace.services.OrderService;
import com.bnta.grechimomarketplace.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/buyers")
public class BuyerController {

    @Autowired
    ProductService productService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    BankCardRepository bankCardRepository;

    @PostMapping
    public ResponseEntity<Buyer> addNewBuyer (@RequestBody Buyer buyer) {
        if (buyer.getCard() == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        // bankCardRepository.save(buyer.getCard());
        return new ResponseEntity<>(buyerService.addNewBuyer(buyer), HttpStatus.CREATED);
    }


    @PatchMapping(value = "{buyerId}")
    public ResponseEntity<Buyer> updateBuyerDetails(@PathVariable Long buyerId,
                                                    @RequestParam Optional<String> name,
                                                    @RequestParam Optional<String> email,
                                                    @RequestParam Optional<String> address,
                                                    @RequestParam Optional<String> password
    ){
        Buyer buyer = buyerService.getBuyerById(buyerId);
        if (buyer == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (name.isPresent()) buyer.setName(name.get());
        if (email.isPresent()) buyer.setEmail(email.get());
        if (address.isPresent()) buyer.setAddress(address.get());
        if (password.isPresent()) buyer.setPassword(name.get());
        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }

    @PutMapping(value = "/{buyerId}")
    public ResponseEntity<BankCard> replaceBankCard(@PathVariable Long buyerId, @RequestBody BankCard newBankCard ){
        Buyer buyer = buyerService.getBuyerById(buyerId);
        buyer.setCard(newBankCard);
        return new ResponseEntity<>(buyer.getCard(), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{buyerId}/product/{productId}")
    public ResponseEntity<ShoppingCartDTO> addProductToCart(@PathVariable Long buyerId,
                                                            @PathVariable Long productId) {
        Buyer buyer = buyerService.getBuyerById(buyerId);
        Product product = productService.getProductById(productId);
        if (buyer == null || product == null ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ShoppingCartDTO dto = buyerService.addProductToCart(buyerId, productId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/{buyerId}/cart")
    public ResponseEntity<ShoppingCartDTO> viewCart(@PathVariable Long buyerId) {
        return new ResponseEntity<>(buyerService.getCart(buyerId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Buyer>> getAllBuyers(){
        List<Buyer> buyers = buyerService.findAllBuyers();
        if(buyers.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity(buyers, HttpStatus.OK);
    }

    @PostMapping(value = "/{buyerId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long buyerId,
                                            @RequestParam String address) {
        Buyer buyer = buyerService.getBuyerById(buyerId);
        if (buyer == null) return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(buyerService.placeOrder(buyerId, address), HttpStatus.OK);
    }

}
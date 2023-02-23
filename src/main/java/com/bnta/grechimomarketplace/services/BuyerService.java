package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.*;
import com.bnta.grechimomarketplace.models.Buyer;
import com.bnta.grechimomarketplace.models.Order;
import com.bnta.grechimomarketplace.models.Product;
import com.bnta.grechimomarketplace.models.ShoppingCartDTO;
import com.bnta.grechimomarketplace.repositories.BuyerRepository;
import com.bnta.grechimomarketplace.repositories.OrderRepository;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class BuyerService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    public Buyer addNewBuyer(Buyer buyer){
        buyerRepository.save(buyer);
        return buyer;
    }

    public List<Buyer> findAllBuyers() {
        List<Buyer> buyers = buyerRepository.findAll();
        return buyers;
    }

// do not touch this method!!
    public Optional<Buyer> getBuyerById(long buyerId){
        Optional <Buyer> buyer = buyerRepository.findById(buyerId);
        return buyer;
    }

    public BuyerDTO findBuyerDTOById(long buyerId){
        Buyer buyer = buyerRepository.findById(buyerId).get();
        return generateBuyerDTO(buyer);
    }

    public BuyerDTO generateBuyerDTO(Buyer buyer){
        return new BuyerDTO(buyer.getId(), buyer.getName(), buyer.getEmail(), buyer.getAddress(),
                buyer.getBuyerShoppingCartDTO(), buyer.getBuyerOrderDTOs());
    }

    public List<BuyerDTO> generateBuyerDTOs(List<Buyer> buyers) {
        List<BuyerDTO> buyerDTOs = new ArrayList<>();
        for (Buyer buyer : buyers) {
            buyerDTOs.add(new BuyerDTO(buyer.getId(), buyer.getName(), buyer.getEmail(), buyer.getAddress(),
                    buyer.getBuyerShoppingCartDTO(),
                    buyer.getBuyerOrderDTOs()));
        }
        return buyerDTOs;
    }

    public ShoppingCartDTO addProductToCart(long buyerId, long productId) {
        Product product = productRepository.findById(productId).get();
        Buyer buyer = buyerRepository.findById(buyerId).get();
        buyer.getCart().add(product);
        buyerRepository.save(buyer);

        List<ProductDTO> productDTOs = productService.generateProductDTOs(buyer.getCart());

        return new ShoppingCartDTO(productDTOs, buyer.getCartTotalValue(), buyer.getCart().size(), buyer.getName(), buyer.getId());
    }
    public ShoppingCartDTO removeProductFromCart(long buyerId, long productId) {
        Product product = productRepository.findById(productId).get();
        Buyer buyer = buyerRepository.findById(buyerId).get();
        if (buyer.getCart().contains(product)) buyer.getCart().remove(product);
        buyerRepository.save(buyer);
        List<ProductDTO> productDTOs = productService.generateProductDTOs(buyer.getCart());
        return new ShoppingCartDTO(productDTOs, buyer.getCartTotalValue(), buyer.getCart().size(), buyer.getName(), buyer.getId());
    }

    public ShoppingCartDTO getCart(long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId).get();
        List<ProductDTO> productDTOs = productService.generateProductDTOs(buyer.getCart());
        return new ShoppingCartDTO(productDTOs, buyer.getCartTotalValue(), buyer.getCart().size(), buyer.getName(), buyer.getId());
    }



    public void saveBuyer(Buyer buyer){
        buyerRepository.save(buyer);
    }
}

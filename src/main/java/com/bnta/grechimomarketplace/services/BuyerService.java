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

    public Buyer addNewBuyer(Buyer buyer){
        buyerRepository.save(buyer);
        return buyer;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Buyer getBuyerById(long buyerId){
        return buyerRepository.findById(buyerId).get();

    }


    public ShoppingCartDTO addProductToCart(long buyerId, long productId) {
        Product product = productRepository.findById(productId).get();
        Buyer buyer = buyerRepository.findById(buyerId).get();
        buyer.getCart().add(product);
        buyerRepository.save(buyer);

        List<ProductDTO> productDTOs = productService.generateProductDTOs(buyer.getCart());

        return new ShoppingCartDTO(productDTOs, buyer.getCartTotalValue(), buyer.getCart().size());
    }

    public ShoppingCartDTO getCart(long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId).get();

        List<ProductDTO> productDTOs = productService.generateProductDTOs(buyer.getCart());

        return new ShoppingCartDTO(productDTOs, buyer.getCartTotalValue(), buyer.getCart().size());
    }

    public Order placeOrder(long buyerId, String address) {
        Optional<Buyer> buyer = buyerRepository.findById(buyerId);
        List<Product> buyerCart = buyer.get().getCart();
        BankCard buyerCard = buyer.get().getCard();
        for (Product product : buyerCart) {
            long productValue = product.getPrice();
            BankCard sellerCard = product.getSeller().getCard();
            buyerCard.reduceMoney(productValue);
            sellerCard.addMoney(productValue);
        }
        Order order = new Order(buyer.get(), address);
        buyer.get().emptyCart();
        orderRepository.save(order);
        return order;
    }

}

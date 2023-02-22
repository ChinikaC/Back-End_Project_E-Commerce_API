package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.*;
import com.bnta.grechimomarketplace.repositories.BuyerRepository;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import com.bnta.grechimomarketplace.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


@Autowired
ProductRepository productRepository;

@Autowired
SellerRepository sellerRepository;



    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findByListedTrue();
        return generateProductDTOs(products);
    }

    public List<ProductDTO> getAllProductsContainingString(String string) {
        List<Product> products = productRepository.findByNameContainingIgnoreCaseAndListedIsTrue(string);
        return generateProductDTOs(products);
    }

    public List<ProductDTO> generateProductDTOs(List<Product> products) {
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getSeller().getName(), product.getSeller().getId(), product.getStock()));
        }
        return productDTOs;
    }

    public Product addNewProductToSellersInventory(long sellerId, Product product) {
        Seller seller = sellerRepository.findById(sellerId).get();
        List<Product> products = seller.getProducts();
        products.add(product);
        product.setSeller(seller);
        productRepository.save(product);
        return product;
    }

    public Product getProductById(long productId){
        return productRepository.findById(productId).get();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(long productId) {
        productRepository.deleteById(productId);
    }
}

package com.bnta.grechimomarketplace.services;

import com.bnta.grechimomarketplace.models.*;
import com.bnta.grechimomarketplace.repositories.BuyerRepository;
import com.bnta.grechimomarketplace.repositories.ProductRepository;
import com.bnta.grechimomarketplace.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


@Autowired
ProductRepository productRepository;

@Autowired
BuyerRepository buyerRepository;

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
            productDTOs.add(new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getSeller().getName()));
        }
        return productDTOs;
    }


}

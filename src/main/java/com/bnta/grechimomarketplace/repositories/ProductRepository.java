package com.bnta.grechimomarketplace.repositories;

import com.bnta.grechimomarketplace.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCaseAndListedIsTrue(String string);

    List<Product> findByListedTrue();
    
}

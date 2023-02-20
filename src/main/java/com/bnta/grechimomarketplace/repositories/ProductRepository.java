package com.bnta.grechimomarketplace.repositories;

import com.bnta.grechimomarketplace.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    
    
}

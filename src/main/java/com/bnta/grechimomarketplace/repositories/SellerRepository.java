package com.bnta.grechimomarketplace.repositories;

import com.bnta.grechimomarketplace.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}

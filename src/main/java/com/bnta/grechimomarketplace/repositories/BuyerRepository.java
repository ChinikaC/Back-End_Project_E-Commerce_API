package com.bnta.grechimomarketplace.repositories;

import com.bnta.grechimomarketplace.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}

package com.bnta.grechimomarketplace.repositories;

import com.bnta.grechimomarketplace.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

package com.bnta.grechimomarketplace.repositories;

import com.bnta.grechimomarketplace.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProducts_Seller_Id(long sellerId);

    List<Order> findByBuyerId(long buyerId);


}

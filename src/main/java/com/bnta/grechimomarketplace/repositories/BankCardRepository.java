package com.bnta.grechimomarketplace.repositories;

import com.bnta.grechimomarketplace.models.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCardRepository extends JpaRepository<BankCard, Long> {
}

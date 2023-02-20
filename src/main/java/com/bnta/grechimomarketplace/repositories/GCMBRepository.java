package com.bnta.grechimomarketplace.repositories;

import com.bnta.grechimomarketplace.models.GCMBMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GCMBRepository extends JpaRepository<GCMBMarketplace, Long> {
}

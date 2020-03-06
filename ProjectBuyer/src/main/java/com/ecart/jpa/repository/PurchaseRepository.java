package com.ecart.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecart.jpa.entity.PurchaseHistory;

import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseHistory, Long> {
    
}

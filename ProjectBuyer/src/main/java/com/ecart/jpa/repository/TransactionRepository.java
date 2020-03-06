package com.ecart.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecart.jpa.entity.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    
}

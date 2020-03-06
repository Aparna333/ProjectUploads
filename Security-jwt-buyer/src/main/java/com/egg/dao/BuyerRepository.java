package com.egg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

	Buyer findByUsername(String username);

}

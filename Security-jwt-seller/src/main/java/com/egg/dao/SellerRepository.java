package com.egg.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

	Seller findByUsername(String username);
 
}

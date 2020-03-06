package com.ecart.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecart.jpa.entity.Buyer;
import com.ecart.jpa.entity.Cart;


@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}

package com.ecart.jpa.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecart.jpa.entity.Seller;
import com.ecart.jpa.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;

	public List<Seller> getAll(Seller seller) {
		
		return sellerRepository.findAll();
	}

	public Seller save(@Valid Seller seller) {
		
		return sellerRepository.save(seller);
	}

}

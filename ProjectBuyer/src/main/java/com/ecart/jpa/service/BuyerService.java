package com.ecart.jpa.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecart.jpa.entity.Buyer;
import com.ecart.jpa.entity.Cart;
import com.ecart.jpa.repository.BuyerRepository;

@Service
public class BuyerService {

	@Autowired
	private BuyerRepository buyerRepository;


	public List<Buyer> findAll() {

		return buyerRepository.findAll();
	}
	
	public Buyer createBuyer(Buyer buyer) {

		return buyerRepository.save(buyer);
	}

	public Buyer updateBuyer(Buyer buyer) {
		Optional<Buyer> buyer1 = buyerRepository.findById(buyer.getBuyerId());
		Buyer b=null;
		if(buyer1.isPresent()) {
			b = buyer1.get();
			b.setUserName(buyer.getUserName());
			b.setPassword(buyer.getPassword());
			b.setEmail(buyer.getEmail());
			b.setMobileNumber(buyer.getMobileNumber());
			b.setCreateDate(buyer.getCreateDate());
			b = buyerRepository.save(b);
		}
		return b;
	}

	public Optional<Buyer> getBuyerById(Long buyerId) {

		return buyerRepository.findById(buyerId);
	}

}

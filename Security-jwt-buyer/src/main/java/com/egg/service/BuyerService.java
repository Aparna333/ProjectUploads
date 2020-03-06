package com.egg.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.egg.dao.BuyerRepository;
import com.egg.model.Buyer;


@Service
public class BuyerService implements UserDetailsService{

	@Autowired
	private BuyerRepository buyerRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public Page<Buyer> findAll(Pageable pageable) {

		return buyerRepository.findAll(pageable);
	}
	
	public Buyer createBuyer(Buyer buyer) {
		buyer.setPassword(bcryptEncoder.encode(buyer.getPassword()));
		return buyerRepository.save(buyer);
	}

	public Buyer updateBuyer(Buyer buyer) {
		Optional<Buyer> buyer1 = buyerRepository.findById(buyer.getBuyerId());
		Buyer b=null;
		if(buyer1.isPresent()) {
			b = buyer1.get();
			b.setUsername(buyer.getUsername());
			b.setPassword(buyer.getPassword());
			b.setEmail(buyer.getEmail());
			b.setMobileNumber(buyer.getMobileNumber());
			b = buyerRepository.save(b);
		}
		return b;
	}

	public Optional<Buyer> getBuyerById(Long buyerId) {

		return buyerRepository.findById(buyerId);
	}

	public Buyer findOne(String username) {
		
		return buyerRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Buyer buyer = buyerRepository.findByUsername(username);
		if(buyer == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(buyer.getUsername(), buyer.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}

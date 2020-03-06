package com.egg.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.egg.dao.SellerRepository;
import com.egg.model.Seller;


@Service
public class SellerService implements UserDetailsService{
	
	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	public List<Seller> getAll(Seller seller) {
		
		return sellerRepository.findAll();
	}

	public Seller save(Seller seller) {
		seller.setPassword(bcryptEncoder.encode(seller.getPassword()));
		return sellerRepository.save(seller);
	}

	public Seller findOne(String username) {
		
		return sellerRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Seller seller = sellerRepository.findByUsername(username);
		if(seller == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(seller.getUsername(), seller.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}

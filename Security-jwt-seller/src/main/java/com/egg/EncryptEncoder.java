package com.egg;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptEncoder {
	
		public static void main(String[] args) {

				String password = "a123";
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(password);

				System.out.println(hashedPassword);

		  }
	}


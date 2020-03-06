package com.egg.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "buyer")
public class Buyer{
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyerId;
    
    @NotNull
    @Size(max = 100)
   // @Column(unique = true)
    private String username;

    @NotNull
    @Size(max = 250)
    private String password;

    @NotNull
    private String email;
    
    private String mobileNumber;
    
    public Buyer() {
		// TODO Auto-generated constructor stub
	}
    

	public Buyer(Long buyerId, String username,String password,
			String email, String mobileNumber) {
		
		this.buyerId = buyerId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}


	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
    
    
}

package com.ecart.jpa.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "buyer")
public class Buyer{
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyerId;
    
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String userName;

    @NotNull
    @Size(max = 250)
    private String password;

    @NotNull
    private String email;
    
    private String mobileNumber;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
    public Date getCreateDate() {
		return createDate;
	}
    
    public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
    
}

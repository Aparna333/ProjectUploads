package com.ecart.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Transactions{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trans_id")
	private int transactionId;
	
	private int userId;
	
    private int sellerId;
    
    private double totalAmount;
    @Column(name="trans_type")
    private String transactionType;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date crateDate;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buyerId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Buyer buyer;
    
    public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(int transactionId, int userId, int sellerId,Double totalAmount, String transactionType, Date dateTime
			) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.sellerId = sellerId;
		this.totalAmount=totalAmount;
		this.transactionType = transactionType;
		

	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", userId=" + userId + ", sellerId=" + sellerId
				+ ", transactionType=" + transactionType + "]";
	}

	public void setBuyerId(Buyer buyer2) {
		
		
	}

	public void setTotalAmount(Double totalAmount) {
		
		
	}
	public Date getCrateDate() {
		return crateDate;
	}
	
	public void setCrateDate(Date crateDate) {
		this.crateDate = crateDate;
	}
    
    
}

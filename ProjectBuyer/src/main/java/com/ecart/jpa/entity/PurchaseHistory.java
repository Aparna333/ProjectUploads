package com.ecart.jpa.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "purchaseHistory")
public class PurchaseHistory{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pur_id")
	private Long purchaseId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "buyerId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Buyer buyer;

	@Column(name="no_items")
	@NotNull
	private int numberOfItems;
	
	public PurchaseHistory() {
		
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public PurchaseHistory(Long purchaseId, Buyer buyer, @NotNull int numberOfItems) {
		super();
		this.purchaseId = purchaseId;
		this.buyer = buyer;
		this.numberOfItems = numberOfItems;
	}

	@Override
	public String toString() {
		return "PurchaseHistory [purchaseId=" + purchaseId + ", buyer=" + buyer
				+ ", numberOfItems=" + numberOfItems + "]";
	}
	


}

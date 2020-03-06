package com.ecart.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Items {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long itemId;
	    
	    @ManyToOne
        @JoinColumn(name = "cat_id")
        @OnDelete(action = OnDeleteAction.CASCADE)
        private Category category;
	    
	    @ManyToOne
        @JoinColumn(name = "subcat_id_fk")
        @OnDelete(action = OnDeleteAction.CASCADE)
        private SubCategory subCategory;
	    
	    private String manufacturer;
	    
        private double price;
        @NotNull
        private String itemName;
        @NotBlank
        @Column(name="desc")
        private String description;
        private int stockNumber;
        private String remarks;
        
        @ManyToOne
        @JoinColumn(name = "seller_id_fk")
        @OnDelete(action = OnDeleteAction.CASCADE)
        private Seller seller;
     
        public Items() {
			
		}
         
		public Items(Long itemId, Category category, SubCategory subCategory, String manufacturer,
				double price, @NotNull String itemName, @NotBlank String description, int stockNumber, String remarks,
				Seller seller) {
			this.itemId = itemId;
			this.category = category;
			this.subCategory = subCategory;
			this.manufacturer = manufacturer;
			this.price = price;
			this.itemName = itemName;
			this.description = description;
			this.stockNumber = stockNumber;
			this.remarks = remarks;
			this.seller = seller;
		}

		public Long getItemId() {
			return itemId;
		}

		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}
		
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getStockNumber() {
			return stockNumber;
		}

		public void setStockNumber(int stockNumber) {
			this.stockNumber = stockNumber;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		
		public Seller getSeller() {
			return seller;
		}

		public void setSeller(Seller seller) {
			this.seller = seller;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public SubCategory getSubCategory() {
			return subCategory;
		}

		public void setSubCategory(SubCategory subCategory) {
			this.subCategory = subCategory;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

}

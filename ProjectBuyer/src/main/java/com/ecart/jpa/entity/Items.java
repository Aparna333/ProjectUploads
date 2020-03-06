package com.ecart.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Items {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long itemId;
	    @NotNull
	    @Column(name="cat_id")
        private int categoryId;
	    @NotNull
        @Column(name="sub_id")
        private int subCategoryId;
	    
        private double price;
        @NotNull
        private String itemName;
        @NotBlank
        @Column(name="desc")
        private String description;
        private Long stockNumber;
        private String remarks;
       
        public Items() {
			
		}

		public Items(Long itemId, int categoryId, int subCategoryId, double price, String itemName, String description,
				Long stockNumber, String remarks) {
			super();
			this.itemId = itemId;
			this.categoryId = categoryId;
			this.subCategoryId = subCategoryId;
			this.price = price;
			this.itemName = itemName;
			this.description = description;
			this.stockNumber = stockNumber;
			this.remarks = remarks;
		}

		public Long getItemId() {
			return itemId;
		}

		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}

		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		public int getSubCategoryId() {
			return subCategoryId;
		}

		public void setSubCategoryId(int subCategoryId) {
			this.subCategoryId = subCategoryId;
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

		public long getStockNumber() {
			return stockNumber;
		}

		public void setStockNumber(long stockNumber) {
			this.stockNumber = stockNumber;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}


		@Override
		public String toString() {
			return "Items [itemId=" + itemId + ", categoryId=" + categoryId + ", subCategoryId=" + subCategoryId
					+ ", price=" + price + ", itemName=" + itemName + ", description=" + description + ", stockNumber="
					+ stockNumber + ", remarks=" + remarks + "]";
		}   
}

package com.ecart.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	@NotNull
	@Column(name="cat_name")
	private String categotyName;
	@NotNull
	@Column(name="cat_dtls")
	private String CategoryDetails;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	
    private Seller seller;
	
	public Category() {
		
	}
	/*@OneToMany
	@JoinColumn(name="sub_cat_id")
	private List<SubCategory> subcat;*/

	public Category(int categoryId, String categotyName, String categoryDetails) {
		super();
		this.categoryId = categoryId;
		this.categotyName = categotyName;
		CategoryDetails = categoryDetails;
	}

	/*public List<SubCategory> getSubcat() {
		return subcat;
	}
	public void setSubcat(List<SubCategory> subcat) {
		this.subcat = subcat;
	}*/
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategotyName() {
		return categotyName;
	}

	public void setCategotyName(String categotyName) {
		this.categotyName = categotyName;
	}

	public String getCategoryDetails() {
		return CategoryDetails;
	}

	public void setCategoryDetails(String categoryDetails) {
		CategoryDetails = categoryDetails;
	}
	
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categotyName=" + categotyName + ", CategoryDetails="
				+ CategoryDetails + "]";
	}

}

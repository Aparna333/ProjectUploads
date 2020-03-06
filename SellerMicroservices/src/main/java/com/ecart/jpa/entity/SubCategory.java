package com.ecart.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class SubCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="sub_id")
	private int subCategoryId;
	@NotNull
	@Column(name="sub_name")
	private String subCategoryName;
	@NotNull
	private int CategoryId;
	
	@Column(name="sub_dtls")
	private String subCategoryDetails;
	
	@Column(name="GST")
	private float gst;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Category category;
	public SubCategory() {
		
	}

	public SubCategory(int subCategoryId, String subCategoryName, int categoryId, String subCategoryDetails,
			float gst) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		CategoryId = categoryId;
		this.subCategoryDetails = subCategoryDetails;
		this.gst = gst;
	}
    
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getSubCategoryDetails() {
		return subCategoryDetails;
	}

	public void setSubCategoryDetails(String subCategoryDetails) {
		this.subCategoryDetails = subCategoryDetails;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", CategoryId="
				+ CategoryId + ", subCategoryDetails=" + subCategoryDetails + ", gst=" + gst + "]";
	}
	
}

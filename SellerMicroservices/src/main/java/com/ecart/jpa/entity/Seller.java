package com.ecart.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Seller {
	 
	@Id
	@GeneratedValue
	private Long sellerId;
	
	@NotNull
	@Column(name="seller_name")
	private String sellerUserName;
	
    @NotNull
	private String password;
    @NotNull
	private String companyName;
                
	@Column(name="GST")
	private int gstIN;
	@NotNull
	@Column(name="comp_dtls")
	private String companyDetails;
	@NotNull
	@Column(name="post_addr")
	private String postalAddress;
	private String website;
    @NotNull
	private String email;
    
    @Size(max = 12)
	@Column(name="con_number")
	private String contactNumber;
	 
	public Seller() {
		// TODO Auto-generated constructor stub
	}

	public Seller(Long sellerId, String sellerUserName, String password, String companyName, int gstIN,
			String companyDetails, String postalAddress, String website, String email, String contactNumber) {
		super();
		this.sellerId = sellerId;
		this.sellerUserName = sellerUserName;
		this.password = password;
		this.companyName = companyName;
		this.gstIN = gstIN;
		this.companyDetails = companyDetails;
		this.postalAddress = postalAddress;
		this.website = website;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerUserName() {
		return sellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getGstIN() {
		return gstIN;
	}

	public void setGstIN(int gstIN) {
		this.gstIN = gstIN;
	}

	public String getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(String companyDetails) {
		this.companyDetails = companyDetails;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerUserName=" + sellerUserName + ", password=" + password
				+ ", companyName=" + companyName + ", gstIN=" + gstIN + ", companyDetails=" + companyDetails
				+ ", postalAddress=" + postalAddress + ", website=" + website + ", email=" + email + ", contactNumber="
				+ contactNumber + "]";
	}
	

}

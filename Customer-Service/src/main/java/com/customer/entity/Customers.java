package com.customer.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Customers {
	
	@Id
	private String id;
	private String companyId;
	private String employeeId;
	private String customerName;
	private String companyName;
	private String gstinNumber;
	private String msmeNumber;
	private String panNumber;
	private String phoneNumber;
	private String website;
	private String address;
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String billingAddress;
	private String billingCity;
	private String billingState;
	private String billingCountry;
	private String billingZipCode;
	private String shippingAddress;
	private String shippingCountry;
	private String shippingState;
	private String shippingCity;
	private String shippingZipCode;
	private boolean status;
	private String email;
	private LocalDateTime createdDate;
	
	
	
	public Customers(String id, String companyId, String employeeId, String customerName, String companyName,
			String gstinNumber, String msmeNumber, String panNumber, String phoneNumber, String website, String address,
			String country, String state, String city, String zipCode, String billingAddress, String billingCity,
			String billingState, String billingCountry, String billingZipCode, String shippingAddress,
			String shippingCountry, String shippingState, String shippingCity, String shippingZipCode,boolean status,LocalDateTime creaDateTime,String email) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.employeeId = employeeId;
		this.customerName = customerName;
		this.companyName = companyName;
		this.gstinNumber = gstinNumber;
		this.msmeNumber = msmeNumber;
		this.panNumber = panNumber;
		this.phoneNumber = phoneNumber;
		this.website = website;
		this.address = address;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.billingAddress = billingAddress;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingCountry = billingCountry;
		this.billingZipCode = billingZipCode;
		this.shippingAddress = shippingAddress;
		this.shippingCountry = shippingCountry;
		this.shippingState = shippingState;
		this.shippingCity = shippingCity;
		this.shippingZipCode = shippingZipCode;
		this.status=status;
		this.createdDate=creaDateTime;
		this.email=email;
	}
	
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getGstinNumber() {
		return gstinNumber;
	}
	public void setGstinNumer(String gstinNumber) {
		this.gstinNumber = gstinNumber;
	}
	public String getMsmeNumber() {
		return msmeNumber;
	}
	public void setMsmeNumber(String msmeNumber) {
		this.msmeNumber = msmeNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingState() {
		return billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getBillingZipCode() {
		return billingZipCode;
	}
	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getShippingCountry() {
		return shippingCountry;
	}
	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public String getShippingZipCode() {
		return shippingZipCode;
	}
	public void setShippingZipCode(String shippingZipCode) {
		this.shippingZipCode = shippingZipCode;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}

package com.fms.model.facility;

public class Address {
	private int addressId;
	private String street;
	private String unit;
	private String city;
	private String state;
	private String zip;
	
	public Address() {}
	
	public int getAddressId() {
		return addressId;
	}
	
	public void setAddressId(int id) {
		this.addressId = string;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

}

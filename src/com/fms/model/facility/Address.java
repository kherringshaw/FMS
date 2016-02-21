package com.fms.model.facility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fms.model.maintenance.MaintenanceRequest;
import com.fms.model.use.Use;

public class Address extends Facility{
	private String addressId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private int capacity;
	private List<Use> usages;
	private List<MaintenanceRequest> inspections;
	private boolean vacant;
	

	
	public Address() {
        usages = new ArrayList<Use>();
	}
	
	public String getAddressId() {
		return addressId;
	}
	
	public void setAddressId(String string) {
		this.addressId = string;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
    public List<Use> getUsages(){
        return usages;
    }

    public void setUsages(List<Use> usages){
        this.usages = usages;
    }

	@Override
	public String toString() {
	return ("Address Information - " + "ID: " + addressId + ", Capacity: " + capacity + ", Description: "+ street );
	}

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	public List<MaintenanceRequest> getInspections() {
		return inspections;
	}

	public void setInspections(List<MaintenanceRequest> inspections) {
		this.inspections = inspections;
	}

}

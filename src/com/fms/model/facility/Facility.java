package com.fms.model.facility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.fms.model.facility.Address;
import com.fms.model.facility.Unit;
import com.fms.model.maintenance.MaintenanceRequest;

public class Facility{
	private int facilityID;
	private double rate;//delete
	private int size;
	private String description;
	private Address address;
	private List<MaintenanceRequest> requests;
	private List<Facility> facList;
	
	//delete later -- this is for testing
	private String last_name;
	
	
	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int id) {
		this.facilityID = id;
	}
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public Address getAddress(){
		return address;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}
	
	
	public List<MaintenanceRequest> getRequests() {
		return requests;
	}

	public void setOrders(List<MaintenanceRequest> requests) {
		this.requests = requests;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public List<Facility> getFacList() {
		return facList;
	}

	public void setFacList(List<Facility> facList) {
		this.facList = facList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
	return ("Facility Information - " + "ID: " + facilityID + ", Size: " + size + ", Description: "+ description );
	}


	

}

package com.fms.model.facility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.fms.model.facility.Address;
import com.fms.model.facility.Unit;
import com.fms.model.maintenance.MaintenanceRequest;

public class Facility{
	private int facilityID;
	private int floor;//deleyte
	private int size;//delete
	private double rate;//delete
	private String description;
	private Address address;
	private Unit unit;
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
	
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public Unit getunit() {
		return unit;
	}

	public void setunit(Unit unit) {
		this.unit = unit;
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
	

}

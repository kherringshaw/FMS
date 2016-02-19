package com.fms.model.use;

import org.joda.time.DateTime;

import java.sql.Date;

import com.fms.model.facility.Address;



public class Use {

    private int usageId;
    private Date startDate;
    private Date endDate;
    private Address address;



    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int id) {
        this.usageId = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address f) { 
        this.address = f;
    }


    
    public String toString() {
    	return ("Use Information - " + "ID: " + ", Address: " + getAddress() +  ", Start Date: "+ getStartDate() +  ", End Date: "+ getEndDate());
    	}
}
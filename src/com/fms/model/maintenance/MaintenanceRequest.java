package com.fms.model.maintenance;

import java.util.Date;

public class MaintenanceRequest {

	private int requestId;
	private String description;
    private RequestType requestType;
    private Status status;
	private Date requestDate;
	private double cost;

    
    public int getRequestId() {
        return requestId;
    }

    
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    
    
	public String getdescription() {
		return description;
	}

	
	public void setdescription(String description) {
		this.description = description;
	}

	
	public Date getRequestDate() {
		return requestDate;
	}

	
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

    
    public RequestType getRequestType() {
        return requestType;
    }

    
    public void setRequestType(RequestType type) {
        this.requestType = type;
    }
    
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}



}
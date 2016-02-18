package com.fms.model.facility;

import java.util.List;

import com.fms.model.use.Use;

public class Unit extends Address {
	private String unit;
	private String unitID;
	private List<Use> usage;
	
	public Unit(){	}

	public List<Use> getUsage() {
		return usage;
	}

	public void setUsage(List<Use> usage) {
		this.usage = usage;
	}
	
	public String getunit() {
		return unit;
	}
	public void setunit(String unit) {
		this.unit = unit;
	}
	
	
	public String getunitID() {
		return unitID;
	}
	public void setunitID(String unitID) {
		this.unitID = unitID;
	}
	


}

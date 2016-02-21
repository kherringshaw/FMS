package com.fms.model.activity;

import com.fms.dal.MaintenanceDAO;
import com.fms.model.maintenance.MaintenanceRequest;

public class MaintenanceActivities {
	
	private MaintenanceDAO maintDAO = new MaintenanceDAO();
	
	//Insert a new facility in the DB
public void makeFacilityMaintRequest(MaintenanceRequest maintReq) {

		
	try {
		System.out.println(maintReq);
		maintDAO.makeFacilityMaintRequest(maintReq);
		System.out.println("Request has been added");
    } catch (Exception se) {
	      System.err.println("Facility: Threw an Exception adding maintenance request.");
	      System.err.println(se.getMessage());
	      System.err.println("this is the error");
    }
}
	
	

}

package com.fms.model.activity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fms.dal.MaintenanceDAO;
import com.fms.model.facility.Facility;
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
	
	//Insert a new facility in the DB
	public boolean scheduleMaintenance(String requestId, Date d){

			
		try {

			return maintDAO.scheduleMaintenance(requestId, d);

		} catch (Exception se) {
		      System.err.println("Facility: Threw an Exception adding maintenance request.");
		      System.err.println(se.getMessage());
		      System.err.println("this is the error");
	    }
		return false;
	}
	
	//Insert a new facility in the DB
    public List<MaintenanceRequest> listMaintenance(String facilityId, boolean status) {

			
		try {

			return maintDAO.listMaintenance(facilityId, status);

	    } catch (Exception se) {
		      System.err.println("Facility: Threw an Exception adding maintenance request.");
		      System.err.println(se.getMessage());
		      System.err.println("this is the error");
	    }
		return null;
	}
	
	//Insert a new facility in the DB
    public double calcProblemRateForFacility(String facilityId){

			
		try {

			return maintDAO.calcProblemRateForFacility(facilityId);

	    } catch (Exception se) {
		      System.err.println("Facility: Threw an Exception adding maintenance request.");
		      System.err.println(se.getMessage());
		      System.err.println("this is the error");
	    }
		return 0;
	}
	
	//Insert a new facility in the DB
    public double calcMaintenanceCostForFacility(String facilityId, boolean status){

			
		try {

			return maintDAO.calcMaintenanceCostForFacility(facilityId, status);

	    } catch (Exception se) {
		      System.err.println("Facility: Threw an Exception adding maintenance request.");
		      System.err.println(se.getMessage());
		      System.err.println("this is the error");
	    }
		return 0;
	}
	

    public List<MaintenanceRequest> listMaintRequests(String facilityId, boolean status){

			
		try {

			return maintDAO.listMaintRequests(facilityId, status);

	    } catch (Exception se) {
		      System.err.println("Facility: Threw an Exception adding maintenance request.");
		      System.err.println(se.getMessage());
		      System.err.println("this is the error");
	    }
		return null;
	}
	

	public List<MaintenanceRequest> listFacilityProblems(String facilityId, boolean status){
		
		List requests = new ArrayList();

			
		try {
			
			return maintDAO.listFacilityProblems(facilityId, status);

	    } 
		
		catch (Exception se) {
		      System.err.println("Facility: Threw an Exception adding maintenance request.");
		      System.err.println(se.getMessage());
		      System.err.println("this is the error");
	    }
		return null;
	}


	
	

}

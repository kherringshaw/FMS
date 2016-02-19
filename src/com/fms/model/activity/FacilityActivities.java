package com.fms.model.activity;


	
import java.util.List;

import com.fms.dal.FacilityDAO;
import com.fms.model.facility.Facility;

public class FacilityActivities {
	private FacilityDAO facDAO = new FacilityDAO();
	
	//search customer by ID from the DB
/*	public Facility findFacilityById(int facilityID) {
				
		try {
			Facility facility = facDAO.getFacility(facilityID);
	    	return facility;
	    } catch (Exception se) {
	      System.err.println("Activity: Threw an Exception retrieving facility.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}*/
		
		//Insert a new facility in the DB
	public void addFacility(Facility facility) {

			
		try {
			System.out.println(facility);
			facDAO.addFacility(facility);
			System.out.println("facility has been added - KH");
	    } catch (Exception se) {
		      System.err.println("Facility: Threw an Exception adding facility.");
		      System.err.println(se.getMessage());
		      System.err.println("this is the error");
	    }
	}
	
	
		//Delete facility in the DB
		public void deleteFacility(int test) {
				
			try {
				facDAO.deleteFacility(test);
				System.out.println("facility has been deleted");
		    } catch (Exception se) {
			      System.err.println("Activity: Threw an Exception deleting facility.");
			      System.err.println(se.getMessage());
		    }
		}
		
		
		
		//Query facility in the DB
		public List<Facility> queryFacilities() {
				
			try {

				return facDAO.queryFacilities();

				
		    } catch (Exception se) {
			      System.err.println("Activity: Threw an Exception in query facility.");
			      System.err.println(se.getMessage());
		    }
			return null;
		}



		

	    public List getFacilityInformation(int facilityId){

	        try {
	            List fac = FacilityDAO.getFacilityInformation(facilityId);
	            return fac;
	        } catch (Exception se) {
	            System.err.println("FacilityService: Threw a Exception retrieving facility.");
	            System.err.println(se.getMessage());
	        }
	        return null;
	    }
	    
	    public boolean assignFacilityToUse(String addressId, boolean isVacant){
//	    	System.out.println("is assignFacilityToUse being called");

	        try {
	        	facDAO.assignFacilityToUse(addressId, isVacant);
	            return isVacant;
	        } catch (Exception se) {
	            System.err.println("FacilityService: Threw a Exception assignFacilityToUse.");
	            System.err.println(se.getMessage());
	        }
	        return (Boolean) null;
	    }
	    
	    
	    
	    
		
	}


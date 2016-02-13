package com.fms.view;



import com.fms.dal.*;
import com.fms.model.activity.FacilityActivities;
import com.fms.model.facility.Facility;
import com.fms.model.facility.Address;
import com.fms.model.*;

import java.sql.*;

public class FacilityUI {
	
	public static void main (String[] args){
		
		DBHelper.DBHelper();
		DBHelper.getConnection();
		DBHelper.executeSQL();
		DBHelper.testPrintSQL();
		
		System.out.println("Facility: *************** add a facility *************************");
		
       
        
        Facility facility1 = new Facility();
        Facility facility2 = new Facility();
		FacilityActivities fac1 = new FacilityActivities();
		
        facility1.setFacilityID(1);
        facility1.setLast_name("test test test");
        facility1.setDescription("this is not arggg");        
        Address address1 = new Address();
        address1.setAddressId("A01");
        System.out.println("this is in the address");
        address1.setStreet("500 West Madison St.");
        address1.setUnit("Suite 1000");
        address1.setCity("Chicago");
        address1.setState("IL");
        address1.setZip("66610");
        facility1.setAddress(address1);        
        
        fac1.addFacility(facility1);
        
        
        
        facility2.setFacilityID(1);
        facility2.setLast_name("rest rest rest");
        facility2.setDescription("this is not rest");
        fac1.addFacility(facility2);
        
        fac1.deleteFacility(3);
        
        fac1.queryFacilities(1);
        
     
        
        
		
		

		

	

	}


}

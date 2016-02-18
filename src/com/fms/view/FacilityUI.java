package com.fms.view;



import com.fms.dal.*;
import com.fms.model.activity.FacilityActivities;
import com.fms.model.facility.Facility;
import com.fms.model.facility.Address;
import com.fms.model.*;

import java.awt.List;
import java.sql.*;
import java.text.SimpleDateFormat;



public class FacilityUI {
	
	public static void main (String[] args){
		
		//DBHelper.DBHelper();
		//DBHelper.getConnection();
		//DBHelper.executeSQL();
		//DBHelper.testPrintSQL();
		
		System.out.println("Facility: *************** add a facility *************************");
		
       
        
        Facility facility1 = new Facility();
        Facility facility2 = new Facility();        
		FacilityActivities fac1 = new FacilityActivities();
		
		
		
		
        facility1.setFacilityID(2);
        facility1.setSize(300000);
        facility1.setDescription("77 West Wacker Building");
        
        //address1 for facility 1
        Address address1 = new Address();
        address1.setFacilityID(2);
        address1.setAddressId("A01");
        address1.setStreet("500 West Madison St.");
        address1.setCity("Chicago");
        address1.setState("IL");
        address1.setZip("66610");
        facility1.setAddress(address1); 
        
        //address2 for facility 1
        /*Address address2 = new Address();
        address1.setFacilityID(2);
        address1.setAddressId("B01");
        address1.setStreet("550 West Madison St.");
        address1.setCity("Chicago");
        address1.setState("IL");
        address1.setZip("66610");
        facility1.setAddress(address2); */
        
        
        fac1.addFacility(facility1);
        
        
        
//        facility2.setFacilityID(3);
//        facility2.setLast_name("Herringshaw");
//        facility2.setDescription("AMLI Rental Apartments");
//        fac1.addFacility(facility2);
        
//        fac1.deleteFacility(2);
        
//        java.util.List<Facility> test = fac1.queryFacilities();
        
//        for (int i = 0; i < test.size(); i++){
 /*       	System.out.println(test.get(i));
        }
        fac1.getFacilityInformation(2);
        

        
        System.out.println(address1.getAddressId()); */
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date startDate;
       // startDate=09-09-2016;
        //dateFormat.parse(startDate);

        
        //address1.setStartDate(09012016);


        
        
        

        
     
        
        
		
		

		

	

	}


}

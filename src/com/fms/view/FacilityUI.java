package com.fms.view;



import com.fms.dal.*;
import com.fms.model.activity.FacilityActivities;
import com.fms.model.facility.Facility;
import com.fms.model.facility.Address;
import com.fms.model.use.Use;
import com.fms.model.*;

import java.awt.List;
import java.sql.*;
import org.joda.time.DateTime;
import java.sql.Date;



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

        
        fac1.addFacility(facility1);
        
//       fac1.deleteFacility(2);
//        fac1.queryFacilities();
//        fac1.getFacilityInformation(2);

        
        Use usage1 = new Use();
        usage1.setAddress(address1);
        usage1.setStartDate(new Date(new DateTime(2014,1,1,1,1).toDate().getTime()));
        usage1.setEndDate(new Date(new DateTime(2014,1,3,1,1).toDate().getTime()));
        
        System.out.println(usage1.getAddress());
        System.out.println(usage1);
        
        Date d1 = new Date(new DateTime(2034,2,3,3,3).toDate().getTime());
        Date d2 = new Date(new DateTime(2034,4,3,3,3).toDate().getTime());
        
       // address1.setVacant(false);
        fac1.assignFacilityToUse("A01", false);
        
        fac1.listActualUsage();
        fac1.calcUsageRate("A01");
        
/*        
        
        
        if(!facilityUseService.IsInUseDuringInterval(unitForUse.getId(),d1,d2))
        {
            facilityUseService.assignFacilityToUse(d1,d2, user1,unitForUse);
        }
        
        

*/
        
        
        

        
     
        
        
		
		

		

	

	}


}

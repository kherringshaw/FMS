package com.fms.view;



import com.fms.dal.*;
import com.fms.model.activity.FacilityActivities;
import com.fms.model.activity.MaintenanceActivities;
import com.fms.model.facility.Facility;
import com.fms.model.facility.Address;
import com.fms.model.maintenance.MaintenanceRequest;
import com.fms.model.maintenance.RequestType;
import com.fms.model.maintenance.Status;
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
		MaintenanceRequest mr = new MaintenanceRequest();
		MaintenanceActivities maintAct = new MaintenanceActivities();
		
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
        address1.setCapacity(50);
        facility1.setAddress(address1); 
        
        //address1 for facility 1
        Address address2 = new Address();
        address2.setFacilityID(2);
        address2.setAddressId("B01");
        address2.setStreet("IBM Building Tower 1");
        address2.setCity("Chicago");
        address2.setState("IL");
        address2.setZip("66610");
        address2.setCapacity(40);
        facility1.setAddress(address2); 

        
        fac1.addFacility(facility1);
        
//       fac1.deleteFacility(2);
//        fac1.queryFacilities();
//        fac1.getFacilityInformation(2);

        
        Use usage1 = new Use();
        usage1.setAddress(address1);
        usage1.setStartDate(new Date(new DateTime(2015,1,1,1,1).toDate().getTime()));
        usage1.setEndDate(new Date(new DateTime(2017,1,1,1,1).toDate().getTime()));
        
//        System.out.println(usage1.getAddress());
 //       System.out.println(usage1);
        
        Date d1 = new Date(new DateTime(2034,2,3,3,3).toDate().getTime());
        Date d2 = new Date(new DateTime(2034,4,3,3,3).toDate().getTime());
        
       // address1.setVacant(false);
        fac1.assignFacilityToUse("A01", false);
        fac1.assignFacilityToUse("B01", true);
        
//        fac1.listActualUsage(1);
//        fac1.calcUsageRate(2);
 //       fac1.requestAvailableCapacity(2);
        
        mr.setRequestId(12);
        mr.setAddressId("A01");
        mr.setRequestType(RequestType.Inspection);
        mr.setdescription("Sent in by tenant coordinator");
        mr.setRequestDate(new Date(new DateTime(2017,1,1,1,1).toDate().getTime()));
        mr.setStatus(Status.open);
        
        maintAct.makeFacilityMaintRequest(mr);
 //       System.out.println("what is mr: " + mr);
        
/*        
        
        
        if(!facilityUseService.IsInUseDuringInterval(unitForUse.getId(),d1,d2))
        {
            facilityUseService.assignFacilityToUse(d1,d2, user1,unitForUse);
        }
        
        

*/
        
        
        

        
     
        
        
		
		

		

	

	}


}

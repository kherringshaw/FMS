package com.fms.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fms.model.facility.Address;
import com.fms.model.facility.Facility;
import com.fms.model.maintenance.MaintenanceRequest;

public class MaintenanceDAO {
	
	public void makeFacilityMaintRequest(MaintenanceRequest maint) {
		Connection con = DBHelper.getConnection();
        PreparedStatement maintPst = null;
//        PreparedStatement addPst = null;
//        PreparedStatement unitPst = null;

        try {
        	System.out.println("this is going in");
        	//Insert the facility object
            String maintStm = "INSERT INTO maintenance(requestId, description, requestType, status, requestDate, cost, addressId) VALUES(?,?,?,?,?,?,?)";
            maintPst = con.prepareStatement(maintStm);
            maintPst.setInt(1, maint.getRequestId());
            System.out.println("what is maint.getregquestid " +  maint.getdescription());
            maintPst.setString(2, maint.getdescription());
            maintPst.setObject(3, maint.getRequestType());
            maintPst.setObject(4, maint.getStatus());
            maintPst.setDate(5, (Date) maint.getRequestDate());
            maintPst.setDouble(6, maint.getCost());
            maintPst.setString(7, maint.getAddressId());
            maintPst.executeUpdate();
            
        } catch (SQLException ex) {

        } finally {

            try {
                if (maintPst != null) {
                	maintPst.close();

                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("MaintenanceDAO: Threw a SQLException saving the maintenance object.");
    	      System.err.println(ex.getMessage());
            }
        }
    }

}

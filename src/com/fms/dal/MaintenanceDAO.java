package com.fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

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
	
	//Returns a list of all problems (all open maintenance requests) for a facility
    public List<MaintenanceRequest> listFacilityProblems(String facilityId, boolean status){
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM MaintenanceRequest WHERE addressId=? AND requestType ='Maintenence'AND status ='open'");
            statement.setString(1,facilityId);
            List requests = new ArrayList();

            ResultSet set = statement.executeQuery();
            while (set.next()){
                requests.add(set.getString(4));
            }
            return requests;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
 
    //Schedules maintenance for a given day and closes the maintenance request
    public Boolean scheduleMaintenance(String requestId, Date d){
    	
    	try {
    		System.out.println("*************** scheduling maintenance request ...  " + requestId);
    		Connection connection = DBHelper.getConnection();
    		
    		PreparedStatement stm = connection.prepareStatement("UPDATE MaintenanceRequest SET Status=closed,appointmentDate=?  WHERE requestId=?");
    		stm.setString(1, d.toString());
    		stm.setString(2, requestId);
    		stm.execute();
    		return true;
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	
    	 return false;
    } 
    
	//Returns a list of all open maintenance requests for a facility
    public List<MaintenanceRequest> listMaintenance(String facilityId, boolean status){
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM MaintenanceRequest WHERE addressId=? AND requestType ='Maintenence'AND status ='closed'");
            statement.setString(1,facilityId);
            List requests = new ArrayList();

            ResultSet set = statement.executeQuery();
            while (set.next()){
                requests.add(set.getString(4));
            }
            return requests;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    
	//Returns the expected cost for all open maintenance requests for a facility
    public double calcMaintenanceCostForFacility(String facilityId, boolean status){
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT cost FROM MaintenanceRequest WHERE addressId=? AND requestType ='Maintenence'AND status ='closed'");
            statement.setString(1,facilityId);
            //List requests = new ArrayList();
            double cost = 0;
            ResultSet set = statement.executeQuery();
            while (set.next()){
                //requests.add(set.getDouble(4));
                cost += (set.getDouble(4));
            }
            return cost;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }
    
	//Returns a list of all open and closed maintenance requests for a facility
    public List<MaintenanceRequest> listMaintRequests(String facilityId, boolean status){
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM MaintenanceRequest WHERE addressId=? AND requestType ='Maintenence'");
            statement.setString(1,facilityId);
            List requests = new ArrayList();

            ResultSet set = statement.executeQuery();
            while (set.next()){
                requests.add(set.getString(4));
            }
            return requests;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    
}
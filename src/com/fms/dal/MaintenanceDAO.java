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
        PreparedStatement preparedStatement = null;
//        PreparedStatement addPst = null;
//        PreparedStatement unitPst = null;

        try {
        	System.out.println("beginning of maintenance adding");
        	
        	preparedStatement = con.prepareStatement("INSERT INTO maintenance (requestId, description, requestType, status) VALUES (?, ?, ?, ?)");
        	preparedStatement.setInt(1, maint.getRequestId());
        	preparedStatement.setString(2, maint.getdescription());
        	preparedStatement.setObject(3, maint.getRequestType());
        	preparedStatement.setObject(4, maint.getStatus());
        	preparedStatement.executeUpdate();
        	//Insert the facility object
           /* String maintStm = "INSERT INTO maintenance(requestId, description, requestType, status, requestDate, cost, addressId) VALUES(?,?,?,?,?,?,?)";
            maintPst = con.prepareStatement(maintStm);
            maintPst.setInt(1, maint.getRequestId());
            System.out.println("what is maint.getregquestid " +  maint.getdescription());
            maintPst.setString(2, maint.getdescription());
            maintPst.setObject(3, maint.getRequestType());
            maintPst.setObject(4, maint.getStatus());
            maintPst.setDate(5, (Date) maint.getRequestDate());
            maintPst.setDouble(6, maint.getCost());
            maintPst.setString(7, maint.getAddressId());
            maintPst.executeQuery();*/
        	/*preparedStatement = con.prepareStatement("INSERT INTO maintenance (requestId, description, requestType, status) VALUES (?, ?, ?, ?)");
        	setValues(preparedStatement, maint.getRequestId(), maint.getdescription(), maint.getRequestType(), maint.getStatus());
        	preparedStatement.executeUpdate();*/

            System.out.println("end of maintenance being added");
            //System.out.println("maintenance: " + maintPst.executeQuery());

            
        } catch (SQLException ex) {

        } finally {

            try {
                if (preparedStatement != null) {
                	preparedStatement.close();

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

            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM maintenance WHERE addressId=? AND requestType ='Maintenence'AND status ='open'");

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
    		
    		PreparedStatement stm = connection.prepareStatement("UPDATE maintenance SET Status=closed,requestDate=?  WHERE requestId=?");
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

            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM maintenance WHERE addressId=? AND requestType ='Maintenence'AND status ='closed'");

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
    
	//Returns the expected cost for all open and closed maintenance requests for a facility
    public double calcMaintenanceCostForFacility(String facilityId, boolean status){
        try{
            Connection connection = DBHelper.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT cost FROM maintenance WHERE addressId=? AND requestType ='Maintenence'AND status ='closed'");

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
    
	//Returns the problem rate per use of a facility
    public double calcProblemRateForFacility(String facilityId){
        Connection connection = DBHelper.getConnection();
        PreparedStatement m = null;
        PreparedStatement u = null;
        try{;
            String mStatement = "SELECT requestID FROM MaintenanceRequest WHERE facilityId=? AND requestType ='Maintenence'";
            String uStatement = "SELECT usageID FROM Use WHERE facilityId=?";
            m=connection.prepareStatement(mStatement);
            u=connection.prepareStatement(uStatement);
            m.setString(1,facilityId);
            u.setString(1,facilityId);
            double requests = 0;
            double uses = 0;
            ResultSet mset = m.executeQuery();
            ResultSet uset = u.executeQuery();
            while (mset.next()){
            	requests++;
            }
            while (uset.next()){
            	uses++;
            }
            return requests/uses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }
    
	//Returns a list of all open and closed maintenance requests for a facility
    public List<MaintenanceRequest> listMaintRequests(String facilityId, boolean status){
        try{
            Connection connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM maintenance WHERE addressId=? AND requestType ='Maintenence'");

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
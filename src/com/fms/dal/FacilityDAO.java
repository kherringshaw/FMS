package com.fms.dal;


	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.fms.model.facility.Address;
import com.fms.model.facility.Facility;
import com.fms.model.facility.Unit;

	public class FacilityDAO {
		
		public FacilityDAO() {}
		
		public Facility getFacility(String facilityID) {
			 	 
		    try { 		
		    	//Get Facility
		    	Statement st = DBHelper.getConnection().createStatement();
		    	String selectFacilityQuery = "SELECT facilityID, size, rate FROM Customer WHERE facilityID = '" + facilityID + "'";

		    	ResultSet facRS = st.executeQuery(selectFacilityQuery);      
		    	System.out.println("faciityDAO: *************** Query " + selectFacilityQuery);
		    	
		      //Get facility
	    	  Facility facility = new Facility();
		      while ( facRS.next() ) {
		    	  facility.setFacilityID(facRS.getInt("facilityID"));
		    	  facility.setSize(facRS.getInt("size"));
		    	  facility.setRate(facRS.getDouble("rate"));
		      }
		      //close to manage resources
		      facRS.close();
		      	    		  
		      //Get Address
		      String selectAddressQuery = "SELECT addressID, street, unit, city, state, zip FROM Address WHERE facilityID = '" + facilityID + "'";
		      ResultSet addRS = st.executeQuery(selectAddressQuery);
	    	  Address address = new Address();
	    	  
	    	  System.out.println("FacilityDAO: *************** Query " + selectAddressQuery);
	    	  
		      while ( addRS.next() ) {
		    	  address.setAddressId(addRS.getString("addressid"));
		    	  address.setStreet(addRS.getString("street"));
		    	  address.setUnit(addRS.getString("unit"));
		    	  address.setCity(addRS.getString("city"));
		    	  address.setState(addRS.getString("state"));
		    	  address.setZip(addRS.getString("zip"));
		      }
		      
		      //facility.setBillingAddress(address);
		      //close to manage resources
		      addRS.close();
		      st.close();
		      
		      return facility;
		    }	    
		    catch (SQLException se) {
		      System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
		      System.err.println(se.getMessage());
		      se.printStackTrace();
		    }
		    
		    return null;
		  }
		
		public void addFacility(Facility fac) {
			Connection con = DBHelper.getConnection();
	        PreparedStatement facPst = null;
	        PreparedStatement addPst = null;
	        PreparedStatement unitPst = null;

	        try {
	        	//Insert the facility object
	            String facStm = "INSERT INTO facility(facilityID, description, size, rate, last_name) VALUES(?, ?, ?, ?, ?)";
	            facPst = con.prepareStatement(facStm);
	            facPst.setInt(1, fac.getFacilityID());
	            facPst.setString(2, fac.getDescription());
	            facPst.setInt(3, fac.getSize());       
	            facPst.setDouble(4, fac.getRate()); 
	            facPst.setString(5, fac.getLast_name());
	            facPst.executeUpdate();

	        	//Insert the facility address object
	            String addStm = "INSERT INTO Address(addressID, facilityID, street, unit, city, state, zip) VALUES(?, ?, ?, ?, ?, ?, ?)";
	            addPst = con.prepareStatement(addStm);
	            addPst.setString(1, fac.getAddress().getAddressId());
	            System.out.println("test");
	            addPst.setInt(2, fac.getFacilityID());
	            addPst.setString(3, fac.getAddress().getStreet());       
	            addPst.setString(4, fac.getAddress().getUnit());  
	            addPst.setString(5, fac.getAddress().getCity());  
	            addPst.setString(6, fac.getAddress().getState());      
	            addPst.setString(7, fac.getAddress().getZip());  
	            addPst.executeUpdate();
	            
	            /**
	        	//Insert the facility address object
	            String unitStm = "INSERT INTO unit(FacilityID, unitID, unit) VALUES(?, ?, ?)";
	            unitPst = con.prepareStatement(unitStm);
	            unitPst.setInt(1, fac.getFacilityID());
	            unitPst.setString(2, fac.getunit().getunitID());  
	            unitPst.setString(3, fac.getunit().getunit());       
	            unitPst.executeUpdate();*/
	            
	        } catch (SQLException ex) {

	        } finally {

	            try {
	                if (addPst != null) {
	                	addPst.close();
	                	facPst.close();
	                	unitPst.close();
	                }
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	      	      System.err.println("FacilityDAO: Threw a SQLException saving the customer object.");
	    	      System.err.println(ex.getMessage());
	            }
	        }
	    }

		public void deleteFacility(int test) {
	        System.out.println("*************** Deleteing facility information in DB with ID ...  " + test);
	        try {
	            Connection connection = DBHelper.getConnection();
	            int removeID = test;
	            String selectRemove = "DELETE FROM Facility WHERE facilityID = '" + removeID + "'";
	            PreparedStatement statement = connection.prepareStatement(selectRemove);
	            
	            statement.executeUpdate();

	            connection.close();

	        }catch (SQLException se){
	            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
	            System.err.println(se.getMessage());
	            se.printStackTrace();
	        }
			
		}
		
		public static void queryFacilities(int test) {
			try {
			Connection connection = DBHelper.getConnection();
			Statement statement = connection.createStatement();
			System.out.println("working");//line above is failing
			ResultSet rs = statement.executeQuery("SELECT * FROM facility WHERE facilityID = '" + test + "'");

			while (rs.next()) {
			System.out.println(rs.getInt(1)+ "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3));
			}
			rs.close();
			statement.close();
			connection.close();
			}
			catch(SQLException e) {
				System.err.println("Got an exception for query! ");
			}
			}
		
	}

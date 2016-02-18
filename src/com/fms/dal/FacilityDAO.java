package com.fms.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.fms.model.facility.Address;
import com.fms.model.facility.Facility;
import com.fms.model.facility.Unit;

	public class FacilityDAO {
		
		
		public FacilityDAO() {}
		
		public Facility getFacility(int facilityID) {
			 	 
		    try { 		
		    	//Get Facility
		    	Statement st = DBHelper.getConnection().createStatement();
		    	String selectFacilityQuery = "SELECT facilityID, size, rate FROM facility WHERE facilityID = '" + facilityID + "'";

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
	            String facStm = "INSERT INTO facility(facilityID, description, size) VALUES(?, ?, ?)";
	            facPst = con.prepareStatement(facStm);
	            facPst.setInt(1, fac.getFacilityID());
	            facPst.setString(2, fac.getDescription());
	            facPst.setInt(3, fac.getSize());
	            facPst.executeUpdate();
	            
/*	            String addStm = "INSERT INTO Address(addressID, facilityID, street) VALUES(?, ?, ?)";
	            addPst = con.prepareStatement(addStm);
	            addPst.setString(1, fac.getAddress().getAddressId());
	            addPst.setInt(2, fac.getFacilityID());
	            addPst.setString(3, fac.getAddress().getStreet()); 
	            addPst.executeUpdate();
	            */
	            
	            

	        	//Insert the facility address object
	            String addStm = "INSERT INTO Address(addressID, facilityID, street, city, state, zip) VALUES(?, ?, ?, ?, ?, ?)";
	            addPst = con.prepareStatement(addStm);
	            addPst.setString(1, fac.getAddress().getAddressId());
	            addPst.setInt(2, fac.getFacilityID());
	            addPst.setString(3, fac.getAddress().getStreet());       
	            addPst.setString(4, fac.getAddress().getCity());  
	            addPst.setString(5, fac.getAddress().getState());      
	            addPst.setString(6, fac.getAddress().getZip());  
	            addPst.executeUpdate();
	            
	            /*
	        	//Insert the unit object
	            String unitStm = "INSERT INTO unit(addressID, unitID, unit) VALUES(?, ?, ?)";
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
	      	      System.err.println("FacilityDAO: Threw a SQLException saving the facility object.");
	    	      System.err.println(ex.getMessage());
	            }
	        }
	    }

		public void deleteFacility(int test) {
	        System.out.println("*************** Deleteing facility information in DB with ID ...  " + test);
	        try {
	            Connection connection = DBHelper.getConnection();
	            int removeID = test;
	            String selectRemove_fac = "DELETE FROM Facility WHERE facilityID = '" + removeID + "'";
	            String selectRemove_address = "DELETE FROM address WHERE facilityID = '" + removeID + "'";
	            PreparedStatement statement_fac = connection.prepareStatement(selectRemove_fac);
	            PreparedStatement statement_address = connection.prepareStatement(selectRemove_address);
	            
	            statement_fac.executeUpdate();
	            statement_address.executeUpdate();

	            connection.close();

	        }catch (SQLException se){
	            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
	            System.err.println(se.getMessage());
	            se.printStackTrace();
	        }
			
		}
		
		public List<Facility> queryFacilities(){
			try {
				Connection connection = DBHelper.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM facility");
				
				List list = new ArrayList();
				//System.out.println("facility DAO");
				while (rs.next()){
					list.add(rs.getString(2));
					//System.out.println("test query");
					//list.add(rs.findColumn("description"), null);
				}
				System.out.println("Here is a list of Facilities");
				System.out.println("____________________________");
				return list;
			}
				catch(SQLException e) {
					System.err.println("Got an exception for query! ");
					System.err.println(e.getMessage());
				}
				return null;
			
		}
		
		public static List getFacilityInformation(int facilityID) {
			try {
				Connection connection = DBHelper.getConnection();
				Statement statement = connection.createStatement();
				System.out.println("working");//line above is failing
				ResultSet rs = statement.executeQuery("SELECT * FROM facility WHERE facilityID = '" + facilityID + "'");
				
				List list2 = new ArrayList();

			while (rs.next()) {
				System.out.println(rs.getInt(1)+ "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3));				
				list2.add(rs.getInt(1)+ "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3));
				}
			
				rs.close();
				statement.close();
				connection.close();
				return list2;
				}
				catch(SQLException e) {
					System.err.println("Got an exception for query! ");
			}
			return null;
			}
		
		
	/*	public static void queryFacilities(int test) {
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
			}*/
		
		//public static Address isInUseDuringInterval(){
			
		//}
		
	}

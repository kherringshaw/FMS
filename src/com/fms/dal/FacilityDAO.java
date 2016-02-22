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
import com.fms.model.maintenance.MaintenanceRequest;

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
	            String addStm = "INSERT INTO Address(addressID, facilityID, street, city, state, zip, capacity) VALUES(?, ?, ?, ?, ?, ?, ?)";
	            addPst = con.prepareStatement(addStm);
	            addPst.setString(1, fac.getAddress().getAddressId());
	            addPst.setInt(2, fac.getFacilityID());
	            addPst.setString(3, fac.getAddress().getStreet());       
	            addPst.setString(4, fac.getAddress().getCity());  
	            addPst.setString(5, fac.getAddress().getState());      
	            addPst.setString(6, fac.getAddress().getZip());  
	            addPst.setInt(7, fac.getAddress().getCapacity());
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
		
//method to either to vacate or to occupy
public boolean assignFacilityToUse(String addressId, boolean isVacant){
	
	try {
		System.out.println("*************** Updating address vacancy with ID ...  " + addressId);
		Connection connection = DBHelper.getConnection();
		
		PreparedStatement stm = connection.prepareStatement("UPDATE address SET isVacant=? WHERE addressId=?");
		stm.setBoolean(1, isVacant);
		stm.setString(2, addressId);
		stm.execute();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	 return isVacant;
}
//this method isn't needed because assignFacilityToUse takes a bool
/*public boolean vacateFacility(String addressId, boolean isVacant){
	
	try {
		System.out.println("*************** Searching for address information with ID ...  " + addressId);
		Connection connection = DBHelper.getConnection();
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("update Address set isVacant=:isVacant where addressId=:addressId");		
		rs.updateString("addressId", addressId);
		rs.updateBoolean("isVacant", isVacant);
		
		
		//rs.executeUpdate();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	 return isVacant;
}*/

		
		
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
		
		public static Boolean isInUseDuringInterval(String facilityID, String start){
			try {
				Connection connection = DBHelper.getConnection();
				PreparedStatement statement = null;
				statement = connection.prepareStatement();
				ResultSet rs = statement.executeQuery("SELECT facilityID FROM facility WHERE facilityID =? and startDate=?");	
				statement.setString(1, facilityID);
				statement.setString(2, start);
				
				System.out.println("Here is a list of ActualUsage");
				System.out.println(list);
				System.out.println("____________________________");
				return list;
			}
				catch(SQLException e) {
					System.err.println("Got an exception for query! ");
					System.err.println(e.getMessage());
				}
				return false;	
			
		}

		public Object listActualUsage(String facilityID) {
			try {
				Connection connection = DBHelper.getConnection();
				//Statement statement = connection.createStatement();
	            String s = "SELECT startDate FROM use WHERE facilityID=? AND startDate =?";
	            PreparedStatement statement = connection.prepareStatement(s);
				ResultSet rs = statement.executeQuery(s);	
				statement.setString(1,facilityID);
				List list = new ArrayList();
				while (rs.next()){
					list.add(rs.getString(2));
				}
				System.out.println("Here is a list of ActualUsage");
				System.out.println(list);
				System.out.println("____________________________");
				return list;
			}
				catch(SQLException e) {
					System.err.println("Got an exception for query! ");
					System.err.println(e.getMessage());
				}
				return null;
			
		}
		
		@SuppressWarnings("unchecked")
		public double calculateUsageRate(int facilityId) {
			double y = 0;
			try {
				Connection connection = DBHelper.getConnection();
				Statement statement = connection.createStatement();
				double usageRate = 0;
				//ResultSet rs1 = statement.executeQuery("SELECT * FROM address WHERE isVacant = 'false'");	
				ResultSet rs = statement.executeQuery("SELECT * FROM address WHERE facilityId = '" + facilityId + "'");
				
				List list1 = new ArrayList();

				while (rs.next()){
					list1.add(rs.getString(9));
				}

				//System.out.println("what type is list1 " + list1.get(0).getClass().getName());
				
				for(int i = 0; i<list1.size(); i++)
					if(list1.get(i).equals("0")){	
						System.out.println("what is the value in list1.get(i): " + list1.get(i));
						y++;						
					}
				
				usageRate = (y/list1.size())*100.0;
				//System.out.println("The number of units in use: " + y);
				System.out.println( "The usage rate for facilityID "+ facilityId + ": " + usageRate );
				//System.out.println(list);
				return usageRate;
			}
				catch(SQLException e) {
					System.err.println("Got an exception for calculateUsageRate! ");
					System.err.println(e.getMessage());
				}
				return (Double) null;
			
		}
		
		@SuppressWarnings("unchecked")
		public int requestAvailableCapacity(int facilityId) {

			try {
				Connection connection = DBHelper.getConnection();
				Statement statement = connection.createStatement();

				ResultSet rs = statement.executeQuery("SELECT * FROM address WHERE facilityId = '" + facilityId + "'");
				
				List<Integer> list1 = new ArrayList();

				while (rs.next()){
					list1.add(rs.getInt(10));
				}

			     Integer sum = new Integer(0); 
			     for (Integer i : list1) {
			         sum = sum + i;
			     }
			     System.out.println("The total capacity for facility " + facilityId + " is: "  + sum);

				return sum;
			}
				catch(SQLException e) {
					System.err.println("Got an exception for calculateUsageRate! ");
					System.err.println(e.getMessage());
				}
				return (Integer) null;
			
		}
		

	    public List<MaintenanceRequest> getInspections(String addressId){
	        try{
	            Connection connection = DBHelper.getConnection();
	            PreparedStatement statement = connection.prepareStatement("SELECT Description FROM MaintenanceRequest WHERE addressId=? AND requestType ='Inspection'");
	            statement.setString(1,addressId);
	            List inspections = new ArrayList();

	            ResultSet set = statement.executeQuery();
	            while (set.next()){
	                inspections.add(set.getString(4));
	            }
	            return inspections;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;

	    }
		
	}

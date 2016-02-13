package com.fms.dal;


import java.sql.*;

public class DBHelper {
	static String url = "jdbc:mysql://localhost:3306/fms";
	static String username = "root";
	static String password = "fpl350clark";
	static Connection connection;
	
	public static void DBHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("driver exists");
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static Connection getConnection() {
		
		System.out.println("Connecting database...");
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		    System.out.println("Database connected!");
			}
			catch(SQLException e) {
				
				System.out.println("DBHelper: Connection Failed! Check output console");
				e.printStackTrace();
				return null;
			    
			}
		
		return connection;

	}
	
	public static void executeSQL() {
		try {
		
	      String query = "update users set num_points = 8000 where id = 2;";
	      PreparedStatement preparedStmt = connection.prepareStatement(query);
	      //preparedStmt.setInt   (1, 6000);
	      //preparedStmt.setString(2, "Fred");
	 
	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	       

	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }

		}

	private void displaySQLErrors(SQLException e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void testPrintSQL() {
		try {

		Statement statement = connection.createStatement();
		System.out.println("working");//line above is failing
		ResultSet rs = statement.executeQuery("SELECT last_name FROM users");

		while (rs.next()) {
		System.out.println(rs.getString(1));
		}
		rs.close();
		statement.close();
		connection.close();
		}
		catch(SQLException e) {
			System.err.println("Got an exception2! ");
		}
		}
}

package edu.gsu.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.gsu.db.CustomerDao;
import edu.gsu.db.CustomerFlightsDao;
import edu.gsu.db.DBqueries;
import edu.gsu.db.FlightDao;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FlightAppService {

	FlightDao flightDao;
	static CustomerDao customerDao;
	static CustomerFlightsDao customerFlightsDao;
	
	public FlightAppService() {
		this.flightDao = new FlightDao();
		this.customerDao = new CustomerDao();
		this.customerFlightsDao = new CustomerFlightsDao();
		
		
	}
	public static boolean login(String username,String password, Button loginButton, Label loginLabel) throws Exception{
		DBqueries connectNow = new DBqueries();
		Connection con = edu.gsu.db.DBqueries.getConnection();
		
		String verifyLogin = "SELECT count(1) FROM Customer WHERE Username = '" + username + "' AND Password = '" + password +"'";
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(verifyLogin);
		
		while(rs.next()) {
			if(rs.getInt(1) == 1) {
			
				return	true;
			
				
			}
		}
		return false;
	}
	
	public static void addFlightToCustomer(String customerID, String flightID ) throws SQLException {
		try {
			customerFlightsDao.createCustomerFlights(customerID, flightID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void customerSignUp(String first, String last, String username, String password) throws SQLException {
		try {
			customerDao.createCustomer(first, last, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String  getUserID(String username) throws SQLException  {
		return customerDao.getCustomerID(username).toString();
		
		
		
	}
	
	public void removeFlightFromCustomer(String customerID, String flightID) {
		
		
	}
	public void sort() {
		
	}
	
}

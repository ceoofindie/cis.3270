package edu.gsu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.gsu.common.Customer;
import edu.gsu.db.queries.CustomerFlightsQueries;
import edu.gsu.db.queries.CustomerQueries;

public class CustomerFlightsDao {
	
 Connection conn;
	
	public CustomerFlightsDao(){
		try {
			this.conn = DbProperties.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  int createCustomerFlights(String customerID, String flightID) throws SQLException {
		
		PreparedStatement create = conn.prepareStatement(CustomerFlightsQueries.createCustomerFlight(customerID, flightID));
		int result = create.executeUpdate();
		return result;
		
	
	}
	
	public int deleteCustomerFlights(String customerID, String flightID) throws SQLException {
		PreparedStatement create = conn.prepareStatement(CustomerFlightsQueries.deleteCustomerFlight(customerID, flightID));
		int result = create.executeUpdate();
		return result;
	}
	
}

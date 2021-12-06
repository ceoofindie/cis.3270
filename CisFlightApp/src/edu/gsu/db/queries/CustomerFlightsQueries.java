package edu.gsu.db.queries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CustomerFlightsQueries {
static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	
	//read customer query
	public static String getCustomerQuery(String uuid) {
		var query = String.format("Select * from project.Customer where customerID = '%s'",uuid);
		System.out.println(query);
		return query;
	}
	
	public static String createCustomerFlight(String customerID, String flightID) {
		var query = String.format("INSERT INTO project.customer_flights (customerID, flightID, dateCreated) VALUES ('%s', '%s', '%s')", 
				 customerID, flightID, formatter.format(new Date()).toString());
		System.out.println(query);
		return query;
	}
	
	public static String deleteCustomerFlight(String customerID, String flightID) {
		var query = (String.format("DELETE FROM project.Flights WHERE flightID AND customerID = '%s', '%s", customerID, flightID));
		System.out.println(query);
		return query;
	}
	
	
}

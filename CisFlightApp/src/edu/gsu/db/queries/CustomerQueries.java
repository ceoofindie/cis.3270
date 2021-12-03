package edu.gsu.db.queries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import edu.gsu.common.Customer;

public class CustomerQueries {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	
	//read customer query
	public static String getCustomerQuery(String uuid) {
		var query = String.format("Select * from project.Customer where customerID = '%d'",uuid);
		System.out.println(query);
		return query;
	}
	
	//create customer query
	public static String createCustomer(String firstName, String lastName, String username, String password) {
		var query = String.format("INSERT INTO project.Customer (customerID, first, last, Username, Password, dateCreated) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", 
				UUID.randomUUID().toString(), firstName, lastName, username, password, formatter.format(new Date()).toString());
		System.out.println(query);
		return query;
	}
	
	// delete customer query
	public static String deleteCustomer(String uuid) {
		var query = (String.format("DELETE FROM project.Customer WHERE customerID = '%d'", uuid));
		System.out.println(query);
		return query;
	}
	//update customer 
	public static String updateCustomer(Customer customer) {
		return(String.format("UPDATE project.Customer "
				+ "SET firstName='%a',"
				+ "lastName='%b',"
				+ "username='c%',"
				+ "password='%d'"
				+ "WHERE customerID='%e'", 
				customer.getFirstName(), customer.getLastName(), customer.getUserName(), customer.getPassword(), customer.getCustomerID()));
	}
}

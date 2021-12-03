package edu.gsu.db.queries;

import edu.gsu.common.Customer;

public class CustomerQueries {
	//read customer query
	public static String getCustomerQuery(String uuid) {
		return (String.format("Select * from projects.Customer where customerID = '%d'",uuid));
	}
	
	//create customer query
	public static String createCustomer(String firstName, String lastName, String username, String password) {
		return (String.format("INSERT INTO projects.Customer(first, last, username, password)", 
				firstName, lastName, username, password ));
	}
	
	// delete customer query
	public static String deleteCustomer(String uuid) {
		return(String.format("DELETE FROM projects.Customer WHERE customerID = '%d'", uuid));
	}
	//update customer 
	public static String updateCustomer(Customer customer) {
		return(String.format("UPDATE projects.Customer "
				+ "SET firstName='%a',"
				+ "lastName='%b',"
				+ "username='c%',"
				+ "password='%d'"
				+ "WHERE customerID='%e'", 
				customer.getFirstName(), customer.getLastName(), customer.getUserName(), customer.getPassword(), customer.getCustomerID()));
	}
}

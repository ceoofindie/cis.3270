package edu.gsu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.gsu.db.DbProperties;
import edu.gsu.db.queries.CustomerQueries;
import edu.gsu.common.Customer;
import edu.gsu.db.queries.CustomerQueries;
//data access object 
public class CustomerDao {
	Connection conn;
	
	public CustomerDao(){
		try {
			this.conn = DbProperties.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//CRUD for data access object
	
	public Customer deleteCustomer(String uuid) throws Exception {
			PreparedStatement posted = conn.prepareStatement(CustomerQueries.deleteCustomer(uuid));	
			ResultSet result = posted.executeQuery();
			return this.toCustomer(result);

	}
	

	public Customer updateCustomer(Customer customer) throws SQLException {
		PreparedStatement update = conn.prepareStatement(CustomerQueries.updateCustomer(customer));
		ResultSet result = update.executeQuery();
		return this.toCustomer(result);
	}

	public Integer createCustomer(Customer customer) throws SQLException {
		PreparedStatement create = conn.prepareStatement(CustomerQueries.createCustomer(customer.getFirstName(), customer.getLastName(), customer.getUserName(), customer.getPassword()));
		int result = create.executeUpdate();
		return result;

	
	}
	public Customer getCustomer(String uuid) throws SQLException{
		PreparedStatement read = conn.prepareStatement(CustomerQueries.getCustomerQuery(uuid));
		
		ResultSet result = read.executeQuery();
		result.next();
		return this.toCustomer(result);
	}
	
	
	private Customer toCustomer(ResultSet result) throws SQLException {
		return new Customer(result.getString("customerID"),
				 result.getString("first"),
				result.getString("last"),
				result.getString("userName"), 
				result.getString("password"),
				result.getString("dateCreated"));
	}
}

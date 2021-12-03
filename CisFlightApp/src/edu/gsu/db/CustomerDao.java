package edu.gsu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.gsu.db.DbProperties;
import edu.gsu.db.queries.CustomerQueries;
import edu.gsu.common.Customer;
import edu.gsu.db.queries.CustomerQueries;

public class CustomerDao {
	Connection conn;
	
	CustomerDao(){
		try {
			this.conn = DbProperties.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Customer deleteCustomer(String uuid) throws Exception {
			PreparedStatement posted = conn.prepareStatement(CustomerQueries.deleteCustomer(uuid));	
			posted.execute();
	}
	

	public Customer updateCustomer(Customer customer) throws SQLException {
		PreparedStatement update = conn.prepareStatement(CustomerQueries.updateCustomer(customer));
		update.execute();
	}

	public Customer createCustomer(Customer customer) throws SQLException {
		PreparedStatement create = conn.prepareStatement(CustomerQueries.createCustomer(customer.getFirstName(), customer.getLastName(), customer.getUserName(), customer.getPassword()));
		create.execute();
	
	}
	
	private String toJson() {
		
	}
	
	private String customer() {
		
	}
}

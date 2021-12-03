package edu.gsu.common;

import java.sql.SQLException;
import edu.gsu.db.CustomerDao;

public class TestDriver {

	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();
		try {
			customerDao.createCustomer(new Customer("",
					"Lance",
					"Shields",
					"DaSkyBaus",
					"password",
					""
					));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

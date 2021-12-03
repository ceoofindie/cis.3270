package edu.gsu.common;

import java.sql.SQLException;
import edu.gsu.db.CustomerDao;
import edu.gsu.db.FlightDao;

public class TestDriver {

	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();
		FlightDao flightDao = new FlightDao();
//		try {
//			
//			flightDao.createFlight(new Flight("",
//					"Delta",
//					"Brooklyn",
//					"Atlanta",
//					"100",
//					"7:30pm",
//					"8:30pm",
//					""
//					));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	
//	CustomerDao customerDao2 = new CustomerDao();
//	try {
//		customerDao2.createCustomer(new Customer("",
//				"Chandler",
//				"Hall",
//				"chanchan47",
//				"chandler1",
//				""
//				));
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
try {
	System.out.println(Customer.toString(customerDao.getCustomer("c94f2b48-e725-4531-a770-9991ebf632b4")));
	System.out.println(Flight.toString(flightDao.getFlight("acbb8f0e-d53d-426f-bb44-24a1ed18bcbb")));

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}


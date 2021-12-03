package edu.gsu.db.queries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import edu.gsu.common.Flight;

public class FlightQueries {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
	//read flight query
public static String getFlightQuery(String uuid) {
	var query = String.format("Select * from project.Flights WHERE flightID = '%s'", uuid);
	System.out.println(query);
	return query;
}
//create flight
public static String createFlight(String airlines, String destination, String departure, String price, String departureTime, String arrivalTime, String FlightDate) {
	var query = String.format("INSERT INTO project.Flights (flightID, airlines, destination, departure, price, departureTime, arrivalTime, FlightDate) VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
			UUID.randomUUID().toString(), airlines, destination, departure, price, departureTime, arrivalTime, formatter.format(new Date()).toString());
		System.out.println(query);
		return query;
}
//delete flight
public static String deleteCustomer(String uuid) {
	var query = (String.format("DELETE FROM project.Flights WHERE flightID = '%s'", uuid));
	System.out.println(query);
	return query;
	}

public static String updateCustomer(Flight flight) {
	return(String.format("UPDATE project.Flights "
			+ "SET airlines = '%s', "
			+ "destination = '%s', "
			+ "departure = '%d', "
			+ "price = '%s', "
			+ "departureTime = '%s' "
			+ "arrivalTime = '%s' "
			+ "WHERE flightID = '%s'",
			flight.getAirlineName(), flight.getDestination(), flight.getDepature(), flight.getPrice(), flight.getDepartureTime(), flight.getArrivalTime()));
}
}

package edu.gsu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.gsu.db.DbProperties;
import edu.gsu.common.Flight;
import edu.gsu.db.queries.CustomerQueries;
import edu.gsu.db.queries.FlightQueries;

public class FlightDao {
Connection conn;

public FlightDao() {
	try {
		this.conn = DbProperties.getConnection();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
//crud for data access object

public Flight deleteFlight(String uuid) throws Exception {
	PreparedStatement posted = conn.prepareStatement(FlightQueries.deleteCustomer(uuid));	
	ResultSet result = posted.executeQuery();
	return this.toFlight(result);
}
//update flight

public Flight updateFlight(Flight flight) throws SQLException{
	PreparedStatement update = conn.prepareStatement(FlightQueries.updateCustomer(flight));
	ResultSet result = update.executeQuery();
	return this.toFlight(result);
}

// create flight
public  Integer createFlight(Flight flight) throws SQLException {
	PreparedStatement create = conn.prepareStatement(FlightQueries.createFlight(flight.getAirlineName(), flight.getDestination(), flight.getDeparture(), flight.getPrice(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getFlightDate()));
	int result = create.executeUpdate();
	return result;
}

//get flight
public Flight getFlight(String uuid) throws SQLException{
	PreparedStatement read = conn.prepareStatement(FlightQueries.getFlightQuery(uuid));
	
	ResultSet result = read.executeQuery();
	result.next();
	return this.toFlight(result);
	
	
}


//read flight
private Flight toFlight(ResultSet result) throws SQLException{
	return new Flight(result.getString("flightID"),
			result.getString("airlines"),
			result.getString("destination"),
			result.getString("departure"),
			result.getString("price"), 
			result.getString("DepartureTime"),
			result.getString("ArrivalTime"),
			result.getString("FlightDate"));
	}
}

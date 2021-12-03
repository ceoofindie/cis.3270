package edu.gsu.db.queries;

public class FlightQueries {
public String getFlightQuery(String uuid) {
	return (String.format("Select * from projects.Flights WHERE flightID = '%d'", uuid));
}

public String createFlight(String airline) {
	
}
}

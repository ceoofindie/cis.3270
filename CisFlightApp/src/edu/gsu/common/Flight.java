package edu.gsu.common;


public class Flight {
public String flightID = null;
public String airlineName = null;
public String destination = null;
public String departure = null;
public String price = null;
public String departureTime = null;
public String arrivalTime = null;
public String flightDate = null;



public Flight() {
	
}

public Flight(String airlineName){
	this.airlineName = airlineName;

}

public Flight(String flightID, String airlineName, String destination, String departure, String price, String departureTime, String arrivalTime, String flightDate ) {
	this.airlineName = airlineName;
	this.price = price;
	this.destination = destination;
	this.departure = departure;
	this.departureTime = departureTime;
	this.arrivalTime = arrivalTime;
	this.flightID = flightID;
	this.flightDate = flightDate;
	
}

public Flight(String airlineName, String destination, String departure, String price, String departureTime, String arrivalTime, String flightDate ) {
	this.airlineName = airlineName;
	this.price = price;
	this.destination = destination;
	this.departure = departure;
	this.departureTime = departureTime;
	this.arrivalTime = arrivalTime;
	this.flightDate = flightDate;
	
	
}


public String getAirlineName() {
	return airlineName;
}
public void setAirlineName(String airlineName) {
	this.airlineName = airlineName;
}

public String getFlightID() {
	return flightID;
}
public void setFlightID(String flightID) {
	this.flightID = flightID;
}
public void setPrice(String price) {
	this.price = price;
	 
}
public String getPrice() {
	return this.price = price;
}
public void setDeparture(String departure) {
	this.departure = departure;
}
public String getDeparture() {
	return this.departure;
}
public void setDestination(String destination) {
	this.destination = destination;
	
}
public String getDestination() {
	return this.destination;
}
public void setDepartureTime(String departureTime) {
	this.departureTime = departureTime;
}
public String getDepartureTime() {
	return this.departureTime;
}
public void setArrivalTime(String arrivalTime) {
	this.arrivalTime = arrivalTime;
}
public String getArrivalTime() {
	return this.arrivalTime;
}

public String getFlightDate() {
	return this.flightDate;
}

public static String toString(Flight flight) {
var format = String.format("Flight: %s %s %s %s %s",flight.getFlightID(), flight.getPrice(), flight.flightDate, flight.getAirlineName(), flight.getDestination());
return format;
}




}

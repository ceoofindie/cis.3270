package edu.gsu.common;


public class Flight {
public String flightID = null;
private String airlineName;
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
	
}

public Flight(String airlineName, String destination, String departure, String price, String departureTime, String arrivalTime, String flightDate ) {
	this.airlineName = airlineName;
	this.price = price;
	this.destination = destination;
	this.departure = departure;
	this.departureTime = departureTime;
	this.arrivalTime = arrivalTime;
	
	
}


public String getAirlineName() {
	return airlineName;
}
public void setAirlineName(String airlineName) {
	this.airlineName = airlineName;
}

public String getflightID() {
	return flightID;
}
public void setflightID(String flightID) {
	this.flightID = flightID;
}
public void setPrice(String price) {
	this.price = price;
	 
}
public String getPrice() {
	return this.price = price;
}
public void setDepature(String depature) {
	this.departure = depature;
}
public String getDepature() {
	return this.departure;
}
public void setDestination(String destination) {
	this.destination = destination;
	
}
public String getDestination() {
	return this.destination;
}
public void setDepatureTime(String departureTime) {
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
var format = String.format("Flight: %s %s %s %s %s",flight.getflightID(), flight.getPrice(), flight.flightDate, flight.getAirlineName(), flight.getDestination());
return format;
}




}

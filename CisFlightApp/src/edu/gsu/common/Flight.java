package edu.gsu.common;

public class Flight {
private int flightID = 16;
private String airlineName;
public String destination = null;
public String depature = null;
public int price = 0;
public String departureTime = null;
public String arrivalTime = null;



public Flight() {
	flightID++;
}

public Flight(String airlineName){
	this.airlineName = airlineName;
	flightID++;
}

public Flight(String airlineName, int price, String destination, String departure, String departureTime, String arrivalTime ) {
	this.airlineName = airlineName;
	this.price = price;
	this.destination = destination;
	this.depature = departure;
	
	this.departureTime = departureTime;
	this.arrivalTime = arrivalTime;
}



public String getAirlineName() {
	return airlineName;
}
public void setAirlineName(String airlineName) {
	this.airlineName = airlineName;
}

public int getflightID() {
	return flightID;
}
public void setflightID(int flightID) {
	this.flightID = flightID;
}
public void setPrice(int price) {
	this.price = price;
	 
}
public int getPrice(int price) {
	return this.price = price;
}
public void setDepature(String depature) {
	this.depature = depature;
}
public String getDepature() {
	return this.depature;
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






}

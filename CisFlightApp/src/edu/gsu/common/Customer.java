package edu.gsu.common;

public class Customer {
private int customerID = 0;
String firstName = null;
String lastName = null;
String userName = null;
String password = null;
Flight[] flights;


public Customer(String firstName, String lastName, String userName, String password) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.password = password;
}

public String getFirstName(){
	return this.firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName(){
	return this.lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserName() {
	return this.userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return this.password;
}
public void setPassword(String password) {
	this.password = password;
}
public Flight[] getFlight() {
	return this.flights;
}
public void setFlight(Flight[] flights) {
this.flights = flights;
}
public void addFlight(Flight[] newFlight) {
	this.flights = newFlight;
}
}
package edu.gsu.common;


public class Customer {
private String customerID = null;
private String firstName = null;
private String lastName = null;
private String userName = null;
private String password = null;
private String dateCreated = null;

public Customer(String customerID, String firstName, String lastName, String userName, String password, String dateCreated) {
	this.customerID =customerID;
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.password = password;
	this.dateCreated = null;
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
public String getCustomerID() {
	return this.customerID;
}

}
package edu.gsu.common;

public class CustomerFlights {
public String customerID;
public String flightID;
public String dateCreated;

public CustomerFlights(String flightID, String dateCreated, String customerId) {
	this.flightID = flightID;
	this.dateCreated = dateCreated;
	this.customerID = customerID;
}

public String getCustomerID() {
	return customerID;
}

public void setCustomerID(String customerID) {
	this.customerID = customerID;
}

public String getFlightID() {
	return flightID;
}

public void setFlightID(String flightID) {
	this.flightID = flightID;
}

public String getDateCreated() {
	return dateCreated;
}

public void setDateCreated(String dateCreated) {
	this.dateCreated = dateCreated;
}


}

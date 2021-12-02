package edu.gsu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBqueries {

	public static void main(String[] args) throws Exception{
getConnection();
	}
	// Updates to DB
	public static void post() throws Exception{
		final String var1 = "Southwest";
		final String var2 = "Spirit";
		final String var3 = "Frontier";
		final String var4 = "Delta";
		final String var5 = "Air Canada";
		final String var6 = "JetBlue";
		final String var7 = "United";
		final String var8 = "American";
		try {
			Connection conn = getConnection();
			PreparedStatement posted = conn.prepareStatement
					("INSERT INTO Flights (airlines) VALUES ('"+var3+"')");
		posted.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Insert Completed");
		}
	}
	public static void createTable()throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS customer_flights(customerID int NOT NULL AUTO_INCREMENT, flightID varchar(255),PRIMARY KEY('customerID))");
			create.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Funtion Complete. ");
			}
	}
	
	public static Connection getConnection() throws Exception{
		try {	String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://34.139.153.60:3306/project";
		String username = "root";
		String password = "Chandler1";
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url,username,password);		
	System.out.println("Connected");
	return conn;
	}catch(Exception e) {System.out.println(e);}
		return null;
	}
}

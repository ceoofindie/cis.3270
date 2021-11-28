package edu.gsu.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws Exception{
		getConnection();
	}
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
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

package edu.gsu.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.gsu.common.Customer;
import edu.gsu.db.DBqueries;
import edu.gsu.db.queries.CustomerQueries;
import javafx.event.ActionEvent;

public class SignUpDao {
public static void add_users(ActionEvent event, String first, String last, String username, String password) throws Exception {
	Connection conn = DBqueries.getConnection();
	String SQL = "INSERT INTO project.Customer VALUES (?, ?, ?, ?)";
	try {
		PreparedStatement pst = conn.prepareStatement(SQL);
		pst.setString(1,first );
		pst.setString(2,last );
		pst.setString(3,username );
		pst.setString(4,password );

	}catch(Exception e) {
		System.out.println(e);
	}
}

}

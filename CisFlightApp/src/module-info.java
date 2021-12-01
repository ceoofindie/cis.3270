module CisFlightApp {
	requires javafx.controls;
	requires java.sql;
	
	opens edu.gsu.gui to javafx.graphics, javafx.fxml;
}

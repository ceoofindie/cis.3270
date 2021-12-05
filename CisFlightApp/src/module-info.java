module CisFlightApp {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	
	opens edu.gsu.gui to javafx.graphics, javafx.fxml;
	opens edu.gsu.common to javafx.graphics, javafx.base;
}

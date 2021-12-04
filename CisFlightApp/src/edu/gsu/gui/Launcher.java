package edu.gsu.gui;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Launcher extends Application {
	
	private static Stage stg;
	
	@Override
	
	public void start(Stage primaryStage) throws Exception {
		stg = primaryStage;
		primaryStage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		primaryStage.setTitle("The coolest app");
		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.show();

		
	
	}
	

	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
}

package edu.gsu.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;






public class Main  extends Application{
	Stage window;
	Scene loginScene, signUpScene;

	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		
		//Set sign up button to lead to sign up scene
		Button signUpButton = new Button("Sign Up");
		GridPane.setConstraints(signUpButton, 3, 5);
		signUpButton.setOnAction(e -> window.setScene(signUpScene));
		
		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton, 2, 5);
		
		
		//designing login screen
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		Label usernameLabel = new Label("Username");
		GridPane.setConstraints(usernameLabel, 1, 2);
		
		TextField usernameText = new TextField();
		GridPane.setConstraints(usernameText, 2, 2);
		// setting password field
		Label passwordLabel = new Label("Password");
		GridPane.setConstraints(passwordLabel, 1, 4);
		
		TextField passwordText = new TextField();
		GridPane.setConstraints(passwordText, 2, 4);
		
		grid.getChildren().addAll( usernameLabel, usernameText, passwordLabel, passwordText, signUpButton, loginButton);
		
		
		//layout 1 - children are laid out in vertical column
		
		loginScene = new Scene(grid, 400, 250);
		
		//signUpScene layout
		GridPane signUpGrid = new GridPane();
		Region r1 = new Region();
		GridPane.setConstraints(r1,0,0);

		Label firstNameLabel = new Label("First name");
		GridPane.setConstraints(firstNameLabel,1,1);
		TextField firstNameText = new TextField();
		GridPane.setConstraints(firstNameText,2,1);
		GridPane.setMargin(firstNameText, new Insets(20, 10, 20, 10) );

		Label lastNameLabel = new Label("Last name");
		GridPane.setConstraints(lastNameLabel,1,3);
		TextField lastNameText = new TextField();
		GridPane.setConstraints(lastNameText,2,3);
		GridPane.setMargin(lastNameText, new Insets(20, 10, 20, 10) );


		Label newUsernameLabel = new Label("New Username");
		GridPane.setConstraints(newUsernameLabel,1,5);

		TextField newUsernameText = new TextField();
		GridPane.setConstraints(newUsernameText,2,5);
		GridPane.setMargin(newUsernameText, new Insets(20, 10, 20, 10) );


		Label newPasswordLabel = new Label("New Password");
		GridPane.setConstraints(newPasswordLabel,1,7);
		

		TextField newPasswordText = new TextField();
		GridPane.setConstraints(newPasswordText,2,7);
		GridPane.setMargin(newPasswordText, new Insets(20, 10, 20, 10) );
		
		Button registerButton = new Button("Sign Up");
		GridPane.setConstraints(registerButton,2, 8);
		GridPane.setMargin(registerButton, new Insets(15, 10, 15, 10) );


		
		

		signUpGrid.setAlignment(Pos.TOP_CENTER);




		signUpGrid.getChildren().addAll(firstNameLabel, firstNameText,lastNameLabel, lastNameText, newUsernameLabel, newUsernameText, newPasswordLabel, newPasswordText, registerButton);
		
		signUpScene = new Scene(signUpGrid, 500, 350);
		
		
		
		
		window.setScene(loginScene);
		window.setTitle("Cis Flight Booking");
		window.show();
	}

	

}

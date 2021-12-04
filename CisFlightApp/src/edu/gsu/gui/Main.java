package edu.gsu.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;

import edu.gsu.common.Flight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;






public class Main  extends Application{
	Stage window;
	Scene loginScene, signUpScene, menuScene, flightScene, myFlightScene;

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
		
		loginScene = new Scene(grid, 400, 200);
		
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
		registerButton.setOnAction(e -> window.setScene(menuScene));

		
		signUpGrid.setAlignment(Pos.TOP_CENTER);

		signUpGrid.getChildren().addAll(firstNameLabel, firstNameText,lastNameLabel, lastNameText, newUsernameLabel, newUsernameText, newPasswordLabel, newPasswordText, registerButton);
		
		signUpScene = new Scene(signUpGrid, 500, 350);
		
		// Menu Scene Layout
		GridPane menu = new GridPane();
		 menuScene = new Scene(menu,300, 300);
		 Button flightsButton = new Button("View Flights");
		flightsButton.setOnAction(e -> window.setScene(flightScene));

		GridPane.setConstraints(flightsButton, 2, 3);
		Button myFlightsButton = new Button("  My Flights ");
		myFlightsButton.setOnAction(e -> window.setScene(myFlightScene));

		GridPane.setConstraints(myFlightsButton, 2, 5);
		menu.setAlignment(Pos.CENTER);
		GridPane.setMargin(flightsButton, new Insets(20, 10, 20, 10) );
		GridPane.setMargin(myFlightsButton, new Insets(20, 10, 20, 10) );
		Button logoutButton = new Button("    Logout      ");
		GridPane.setConstraints(logoutButton, 2, 7);
		GridPane.setMargin(logoutButton, new Insets(20, 10, 20, 10) );

		logoutButton.setOnAction(e -> window.setScene(loginScene));
		menu.getChildren().addAll(flightsButton, myFlightsButton, logoutButton);
		
		//Setting up flights layout
		
		VBox flightVbox = new VBox();
		flightScene = new Scene(flightVbox, 600, 500);
		
		
		
		TableView<Flight> flightTableView = new TableView<Flight>();
		flightTableView.setEditable(true);
		TableColumn<Flight, String> airlinesColumn = new TableColumn<Flight, String>("Airlines");
		TableColumn<Flight, String> destinationColumn = new TableColumn<Flight, String>("Destination");
		TableColumn<Flight, String> departureColumn = new TableColumn<Flight, String>("Departure");
		TableColumn<Flight, String> priceColumn = new TableColumn<Flight, String>("price");
		TableColumn<Flight, String> departureTimeColumn = new TableColumn<Flight, String>("Departure Time");
		TableColumn<Flight, String> arrivalTimeColumn = new TableColumn<Flight, String>("Arrival Time");
		TableColumn<Flight, String> flightDateColumn = new TableColumn<Flight, String>("Date");

		flightTableView.getColumns().add(airlinesColumn);
		flightTableView.getColumns().add(destinationColumn);
		flightTableView.getColumns().add(departureColumn);
		flightTableView.getColumns().add(priceColumn);
		flightTableView.getColumns().add(departureTimeColumn);
		flightTableView.getColumns().add(arrivalTimeColumn);
		flightTableView.getColumns().add(flightDateColumn);
		
		airlinesColumn.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
		destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
		departureColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		departureTimeColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		flightDateColumn.setCellValueFactory(new PropertyValueFactory<>("flightDate"));

		ObservableList<Flight> allFlightObList = FXCollections.observableArrayList();

		getFlights(allFlightObList);
		
		flightTableView.setItems(allFlightObList);

		//make buttons
		Button bookButton = new Button("Book");
		HBox.setMargin(bookButton, new Insets(20, 20, 20, 10) );
		
		//Sort Button
		Button sortButton = new Button("Sort");
		HBox.setMargin(sortButton, new Insets(20, 20, 20, 10) );
		//menu button to go back
		Button menuButton = new Button("Menu");
		VBox.setMargin(menuButton, new Insets(20, 20, 20, 10) );
		menuButton.setOnAction(e -> window.setScene(menuScene));

		


		
	
		
		//choice box
		ChoiceBox<String> airlinesChoiceBox =  new ChoiceBox<>();
		ChoiceBox<String> destinationChoiceBox =  new ChoiceBox<>();
		ChoiceBox<String> departureChoiceBox =  new ChoiceBox<>();
		ChoiceBox<String> departureTimeChoiceBox =  new ChoiceBox<>();
		ChoiceBox<String> dateChoiceBox =  new ChoiceBox<>();

		
		//getItems returns the obserevable list that you add the items to
		airlinesChoiceBox.getItems().add("Airlines");
		airlinesChoiceBox.getItems().add("American");
		airlinesChoiceBox.getItems().add("Delta");
		airlinesChoiceBox.getItems().add("Spirit");
		airlinesChoiceBox.getItems().add("United");
		airlinesChoiceBox.getItems().add("Frontier");
		airlinesChoiceBox.getItems().add("JetBlue");
		airlinesChoiceBox.getItems().add("Southwest");
		airlinesChoiceBox.getItems().add("Air Canada");
		//set airlines as default value
		airlinesChoiceBox.setValue("Airlines");
		
		
		//getItems for sort
		destinationChoiceBox.getItems().add("Destination");
		destinationChoiceBox.setValue("Destination");
		
		departureChoiceBox.getItems().add("Departure");
		departureChoiceBox.setValue("Departure");

		departureTimeChoiceBox.getItems().add("Departure Time");
		departureTimeChoiceBox.setValue("Departure Time");
		
		dateChoiceBox.getItems().add("Date");
		dateChoiceBox.setValue("Date");
		
		
		
		HBox.setMargin(airlinesChoiceBox, new Insets(40, 10, 40, 10) );
		HBox.setMargin(destinationChoiceBox, new Insets(40, 10, 40, 10) );
		HBox.setMargin(departureChoiceBox, new Insets(40, 10, 40, 10) );
		HBox.setMargin(departureTimeChoiceBox, new Insets(40, 10, 40, 10) );
		HBox.setMargin(dateChoiceBox, new Insets(40, 10, 40, 10) );

		
		
		// Hbox for buttons
		HBox buttonHbox = new HBox();
		//created hbox for sorting
		HBox sortHbox = new HBox();
		

		



	


		
		
		//Edit get children to switch elements position
		
		flightVbox.getChildren().addAll(flightTableView, buttonHbox, sortHbox, menuButton);
		
		sortHbox.getChildren().addAll(airlinesChoiceBox,destinationChoiceBox,departureChoiceBox,departureTimeChoiceBox, dateChoiceBox );
		buttonHbox.getChildren().addAll(bookButton,sortButton );
		
		
		//Making myFlights Scene
		VBox myFlightVbox = new VBox();
		myFlightScene = new Scene(myFlightVbox, 600, 500);
		
		TableView<Flight> myFlightTableView = new TableView<Flight>();
		myFlightTableView.setEditable(true);
		TableColumn<Flight, String> flightsColumn = new TableColumn<Flight, String>("My Flights");
		myFlightTableView.getColumns().add(flightsColumn);
		
		
		//create hbox
		HBox myFlightsHbox = new HBox();
		
		
		
		//adding buttons
		Button myFlightMenuButton = new Button("Menu");
		VBox.setMargin(myFlightMenuButton, new Insets(20, 20, 20, 10) );
		myFlightMenuButton.setOnAction(e -> window.setScene(menuScene));
		
		Button removeFlightButton = new Button("Remove Flight");
		HBox.setMargin(removeFlightButton, new Insets(20, 20, 20, 10) );
		
		//create choice box
		ChoiceBox<String> flightsChoiceBox =  new ChoiceBox<>();
		flightsChoiceBox.getItems().add("Flights");
		flightsChoiceBox.setValue("Flights");
		HBox.setMargin(flightsChoiceBox, new Insets(20, 20, 20, 10) );
	




		
		
		
		myFlightVbox.getChildren().addAll(myFlightTableView, myFlightsHbox, myFlightMenuButton);
		myFlightsHbox.getChildren().addAll(flightsChoiceBox, removeFlightButton);
		
		
		
		
		
		window.setScene(loginScene);
		window.setTitle("CIS Flight Booking");
		window.show();
	}
	
	public void getFlights(ObservableList<Flight> allFlightObList) throws Exception {
	Connection conn = edu.gsu.db.DBqueries.getConnection();
	ResultSet rs = conn.createStatement().executeQuery("Select * from Flights");
	while(rs.next()) {
		allFlightObList.add(new Flight(rs.getString("airlines"), rs.getString("destination"), rs.getString("departure"), rs.getString("price"), rs.getString("DepartureTime"), rs.getString("ArrivalTime"), rs.getString("FlightDate")));
	}
	}
	

}

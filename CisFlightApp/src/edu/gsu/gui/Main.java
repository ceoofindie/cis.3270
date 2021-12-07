package edu.gsu.gui;


import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.gsu.db.CustomerDao;
import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.common.FlightAppService;
import edu.gsu.db.DBqueries;
import edu.gsu.db.queries.CustomerQueries;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;






public class Main  extends Application {
	Stage window;
	Scene loginScene, signUpScene, menuScene, flightScene, myFlightScene;
	
	FlightAppService flightAppService = new FlightAppService();

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
		// if statement to validate login
		TextField usernameText = new TextField();
		TextField passwordText = new TextField();
		Label loginMessageLabel = new Label();
		GridPane.setConstraints(loginMessageLabel, 2, 7);

		
//			if(usernameText == false && == false) {
//				validateLogin(usernameText.getText(), passwordText.getText(), loginButton);
//			}

		Label customerIDLabel;
		customerIDLabel = new Label();
		
		
		
		
	
		loginButton.setOnAction(e ->{
			if(usernameText.getText().isEmpty() == false && passwordText.getText().isEmpty() == false) {
				try {
				var login = FlightAppService.login(usernameText.getText(), passwordText.getText(), loginButton, loginMessageLabel );
				
				if(login) {
					window.setScene(menuScene);
					
					
					//String username = usernameText.getText();
//					Customer newCustomer = CustomerDao.getCustomer(usernameText.getText());
					Customer newCustomer = CustomerDao.getCustomer(usernameText.getText());
					String customerID = newCustomer.getCustomerID();
//				
//					
//					String userIDDB = FlightAppService.getUserID(username);

				
					customerIDLabel.setText(customerID);
				}
				

					loginMessageLabel.setText(" ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else {
				loginMessageLabel.setText("Invalid");
			}
			
//			if(loginMessageLabel.getText() == " ") {
//				window.setScene(menuScene);
//
//			}
		});
	
		
	

		String customerID2 = customerIDLabel.getText();
	
		
		//designing login screen
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		Label usernameLabel = new Label("Username");
		GridPane.setConstraints(usernameLabel, 1, 2);
		
		
		GridPane.setConstraints(usernameText, 2, 2);
		// setting password field
		Label passwordLabel = new Label("Password");
		GridPane.setConstraints(passwordLabel, 1, 4);
		
		GridPane.setConstraints(passwordText, 2, 4);
		
		grid.getChildren().addAll( usernameLabel, usernameText, passwordLabel, passwordText, signUpButton, loginButton,loginMessageLabel);
		
		
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
		
		registerButton.setOnAction(e ->{
		 try {
			FlightAppService.customerSignUp(firstNameText.getText(), lastNameText.getText(), newUsernameText.getText(), newPasswordText.getText());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			window.setScene(menuScene);

		});
//		CustomerDao.createCustomer1(newCustomer);
//		registerButton.setOnAction(e -> {
//			try {
//				SignUpDao.add_users(e, firstNameText.getText(), lastNameText.getText(), newUsernameText.getText(), newPasswordText.getText());
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});
		
		
//		SignUpUser(registerButton.getOnAction() ,firstNameText.getText(),lastNameText.getText(), newUsernameText.getText(), newPasswordText.getText() );
//		registerButton.setOnAction(e2-> window.setScene(menuScene));
		signUpGrid.setAlignment(Pos.TOP_CENTER);

		signUpGrid.getChildren().addAll(firstNameLabel, firstNameText,lastNameLabel, lastNameText, newUsernameLabel, newUsernameText, newPasswordLabel, newPasswordText, registerButton);
		
		signUpScene = new Scene(signUpGrid, 500, 350);
		
		// Menu Scene Layout
		GridPane menu = new GridPane();
		VBox customerIDVBox = new VBox();
		menuScene = new Scene(customerIDVBox,300, 300);
		 Button flightsButton = new Button("View Flights");
		flightsButton.setOnAction(e -> window.setScene(flightScene));

		
		
		HBox.setMargin(customerIDLabel, new Insets(20, 10, 20, 10) );
		

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
		customerIDVBox.getChildren().addAll(customerIDLabel, menu);
		menu.getChildren().addAll(flightsButton, myFlightsButton, logoutButton);


		
		//Setting up flights layout
		
		VBox flightVbox = new VBox();
		flightScene = new Scene(flightVbox, 700, 500);
		
		
		
		TableView<Flight> flightTableView = new TableView<Flight>();
		flightTableView.setEditable(true);
		
		
		TableColumn<Flight, String> flightIDColumn = new TableColumn<Flight, String>("Flight ID");
		TableColumn<Flight, String> airlinesColumn = new TableColumn<Flight, String>("Airlines");
		TableColumn<Flight, String> destinationColumn = new TableColumn<Flight, String>("Destination");
		TableColumn<Flight, String> departureColumn = new TableColumn<Flight, String>("Departure");
		TableColumn<Flight, String> priceColumn = new TableColumn<Flight, String>("Price");
		TableColumn<Flight, String> departureTimeColumn = new TableColumn<Flight, String>("Departure Time");
		TableColumn<Flight, String> arrivalTimeColumn = new TableColumn<Flight, String>("Arrival Time");
		TableColumn<Flight, String> flightDateColumn = new TableColumn<Flight, String>("Date");
	
		flightTableView.getColumns().add(flightIDColumn);
		flightTableView.getColumns().add(airlinesColumn);
		flightTableView.getColumns().add(destinationColumn);
		flightTableView.getColumns().add(departureColumn);
		flightTableView.getColumns().add(priceColumn);
		flightTableView.getColumns().add(departureTimeColumn);
		flightTableView.getColumns().add(arrivalTimeColumn);
		flightTableView.getColumns().add(flightDateColumn);
		

		flightIDColumn.setCellValueFactory(new PropertyValueFactory<>("flightID"));
		airlinesColumn.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
		destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
		departureColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		departureTimeColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		flightDateColumn.setCellValueFactory(new PropertyValueFactory<>("FlightDate"));



		ObservableList<Flight> allFlightObList = FXCollections.observableArrayList();

		getFlights(allFlightObList);
		
		flightTableView.setItems(allFlightObList);

		//make buttons
		Button bookButton = new Button("Book");
		HBox.setMargin(bookButton, new Insets(20, 20, 20, 10) );
		
//		bookButton.setOnAction(e ->{
//			FlightAppService.addFlightToCustomer(STYLESHEET_MODENA, STYLESHEET_CASPIAN);
//		});
		
		//Sort Button
		Button sortButton = new Button("Sort");
		HBox.setMargin(sortButton, new Insets(20, 20, 20, 10) );
		//menu button to go back
		Button menuButton = new Button("Menu");
		VBox.setMargin(menuButton, new Insets(20, 20, 20, 10) );
		menuButton.setOnAction(e -> window.setScene(menuScene));

		 {
		bookButton.setOnAction(e -> {
			Flight newFlight = flightTableView.getSelectionModel().getSelectedItem();
			String flightID =newFlight.getFlightID();
			System.out.println(customerID2);
			
			try {
				FlightAppService.addFlightToCustomer(customerIDLabel.getText()
,flightID);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		});
		}
			
		


	
		
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
		GridPane buttonGrid = new GridPane();
		//created hbox for sorting
		HBox sortHbox = new HBox();
		
		buttonGrid.setAlignment(Pos.CENTER);
		GridPane.setConstraints(bookButton, 2, 6);


		

		


		
	


		
		
		//Edit get children to switch elements position
		
		flightVbox.getChildren().addAll(flightTableView, buttonGrid,  menuButton);
		
		sortHbox.getChildren().addAll(airlinesChoiceBox,destinationChoiceBox,departureChoiceBox,departureTimeChoiceBox, dateChoiceBox );
		buttonGrid.getChildren().addAll(bookButton );
		
		
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
		allFlightObList.add(new Flight(rs.getString("flightID"), rs.getString("airlines"), rs.getString("destination"), rs.getString("departure"), rs.getString("price"), rs.getString("DepartureTime"), rs.getString("ArrivalTime"), rs.getString("FlightDate")));
	}
	}
	
	
	
	public void validateLogin(String username,String password, Button loginButton, Label loginLabel) throws Exception {
		DBqueries connectNow = new DBqueries();
		Connection con = edu.gsu.db.DBqueries.getConnection();
		
		String verifyLogin = "SELECT count(1) FROM Customer WHERE Username = '" + username + "' AND Password = '" + password +"'";
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(verifyLogin);
		
		while(rs.next()) {
			if(rs.getInt(1) == 1) {
				window.setScene(menuScene);
				
			}
		}
		
		
		
		
	}
	public static void SignUpUser(EventHandler<ActionEvent> eventHandler, String firstname, String lastname, String username, String password) throws Exception {
		Connection conn = null;
		PreparedStatement psInsert = null;
		PreparedStatement psCheckUserExists = null;	
		ResultSet rs = null;
		
		try {
			conn = DBqueries.getConnection();
			psCheckUserExists = conn.prepareStatement("SELECT * FROM Customer WHERE Username = %s");
			psCheckUserExists.setString(1, username);
			rs = psCheckUserExists.executeQuery();
			
			if(rs.isBeforeFirst()) {
				System.out.println("User already exists");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("You cant use this username");
				alert.show();
				
			}else {
				psInsert = conn.prepareStatement("INSERT INTO Customer(first, last, username, password VALUES (%s,%s,%s,%s)");
				psInsert.setString(1,firstname);
				psInsert.setString(2,lastname);
				psInsert.setString(3,username);
				psInsert.setString(4,password);
				psInsert.executeUpdate();


			}
			}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(psCheckUserExists != null) {
				try {
					psCheckUserExists.close();
				}catch(SQLException e) {
					
				}
				
			}
		}
	}
	
	
	
	

}

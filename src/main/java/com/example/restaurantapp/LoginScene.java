package com.example.restaurantapp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LoginScene {

	// Declare class member
    TextField pinField;
    
    public Scene setupLoginScene() {

        // Initialise the pane and scene
        BorderPane loginRoot = new BorderPane();
        Scene loginScene = new Scene(loginRoot, 1280, 720);

        // Label setup
        Label pinPrompt = new Label("Enter your PIN");
        pinPrompt.setMaxWidth(500);
        pinPrompt.setAlignment(Pos.CENTER);
        pinPrompt = App.setFontSize(pinPrompt, 20);

        // Pin input setup
        pinField = new TextField();
        pinField.setPromptText("PIN");
        pinField.setMaxWidth(100);
        pinField = App.textFieldValidation(pinField, "\\d{4}", "Invalid pin entered. Must be 4 digits.");

        // Login button setup
        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(e -> loginBtnCode());

        Button helpBtn = new Button("Help");
        helpBtn.setOnAction(e -> AlertBox.showHelpScreen("Enter a 4 digit pin to log in.\nIf the pin belongs to a manager you will be taken to the days takings screen.\nIf the pin belongs to a normal staff member you will be taken to the menu.\nThere are 2 default pins: \nManager: 1234\nNormal Staff: 5678."));
        
        Button createNewEmployeeBtn = new Button("Create New Staff Member");
        createNewEmployeeBtn.setOnAction(e -> createNewEmployeeBtnCode());

        // Vbox to hold everything
        VBox pinContainer = new VBox(30);
        pinContainer.setAlignment(Pos.CENTER);
        pinContainer.setMaxWidth(500);
        pinContainer.getChildren().addAll(pinPrompt, pinField, loginBtn, helpBtn, createNewEmployeeBtn);

        loginRoot.setCenter(pinContainer);
        
        return loginScene;

    }
    

	// Code for the login button to execute
    private void loginBtnCode() {

        boolean isValidUser = false;

        short pinEntered = 0;
		try {
			pinEntered = Short.parseShort(pinField.getText());
			
		} catch (Exception e) {
			AlertBox.notifyUser("Invalid Pin", "Pin cannot be empty.");
		} 
        
		// If pin is still its default value dont run the rest of the code
		if (pinEntered != 0) {
			
			byte i = 0;
	        do {
	            StaffMember staffMember = App.staffMembers[i];

	            // Compare pin of current staff member from array to entered pin
	            if (staffMember.getPin() == pinEntered) {
	                isValidUser = true;
	                
	                // If pin is valid change the scene depending on whether they are a manager or not
	                App.globalStage.setScene(staffMember.isManager() ? App.managerTakingsScene : App.menuScene);
	            }

	            i++;
	        } while (!isValidUser && i < App.staffMembers.length);

	        if (!isValidUser) {
	            AlertBox.notifyUser("Invalid Pin", "This pin does not exist.");
	        }
	        
		}
		
    }

    private void createNewEmployeeBtnCode() {

        App.globalStage.setScene(App.createEmployeeScene);

    }
    
}

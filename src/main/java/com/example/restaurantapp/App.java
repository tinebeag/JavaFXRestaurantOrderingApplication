package com.example.restaurantapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.DecimalFormat;


public class App extends Application {

    public static Stage globalStage;

    // Declare the objects for each scene
    public static LoginScene loginSceneObj;
    public static MenuScene menuSceneObj;
    public static PaymentScene paymentSceneObj;
    public static CreateEmployeeScene createEmployeeSceneObj;
    public static ManagerTakingsScene managerTakingsSceneObj;

    // Declare the scenes
    public static Scene loginScene;
    public static Scene menuScene;
    public static Scene paymentScene;
    public static Scene createEmployeeScene;
    public static Scene managerTakingsScene;

    // Declare the global variables
    public static StaffMember[] staffMembers;
    public static DecimalFormat fmt;


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        // Link the global stage with the local stage of the start method
        // The global stage can then be manipulated in other classes
        globalStage = stage;
        stage.setTitle("Restaurant Order App");
        stage.setOnCloseRequest(e -> {
            e.consume();
            confirmProgramClose();
        });

        // Initialise the global variables
        staffMembers = getInitialStaffMembers();
        fmt = new DecimalFormat("'€'###,###,##0.00");

        // Initialise the objects for each scene
        loginSceneObj = new LoginScene();
        menuSceneObj = new MenuScene();
        paymentSceneObj = new PaymentScene();
        createEmployeeSceneObj = new CreateEmployeeScene();
        managerTakingsSceneObj = new ManagerTakingsScene();

        // Initialise the scenes and add stylesheet
        loginScene = loginSceneObj.setupLoginScene();
        menuScene = menuSceneObj.setupMenuScene();
        paymentScene = paymentSceneObj.setupPaymentScene();
        createEmployeeScene = createEmployeeSceneObj.setupCreateEmployeeScene();
        managerTakingsScene = managerTakingsSceneObj.setupManagerTakingsScene();

        stage.setScene(loginScene);

        stage.show();

    }

    private void confirmProgramClose() {

        Boolean close = AlertBox.showAlertWithConfirmation("Close Program?", "Are you sure you want to close?", "Close");
        if (close) {
            globalStage.close();
            System.exit(0);
        }

    }

    // Method to populate the staff members array on start
    private StaffMember[] getInitialStaffMembers() {

        StaffMember[] newStaffMembersArray = new StaffMember[2];

        newStaffMembersArray[0] = new StaffMember((short) 1234,
                "Sean",
                "Murphy",
                (byte) 25,
                "Male",
                "sean.murphy@outlook.com",
                "0874379004",
                "4 Down That Road There",
                null,
                null,
                "9384859X",
                true);

        newStaffMembersArray[1] = new StaffMember((short) 5678,
                "Mary",
                "Ahern",
                (byte) 20,
                "Female",
                "mary.ahern@gmail.com",
                "0834977654",
                "9 Up Along That Way",
                null,
                null,
                "5927431P",
                false);

        return newStaffMembersArray;

    }

    // Function to add a listener to a text field that checks against the provided regex parameter
    public static TextField textFieldValidation(TextField textField, String regex, String errorMsg) {

        textField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // When focus lost
                if (textField.getText().trim().isBlank()) {
                    textField.setText("");
                }
                else if(!textField.getText().matches(regex)){
                    textField.setText(""); // Clear the text if it is invalid

                    AlertBox.notifyUser("Invalid Input", errorMsg);
                }
            }
        });

        return  textField;

    }

    // Code for the logout button to execute
    public static void logoutBtnCode() {

        App.loginSceneObj.pinField.clear();
        globalStage.setScene(loginScene);

    }

    public static Label setFontSize(Label lbl, int size) {

        lbl.setFont(Font.font(size));

        return lbl;

    }

}

package com.example.restaurantapp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateEmployeeScene {

	// Declare class members
    TextField newPinField;
    TextField newFirstNameField;
    TextField newLastNameField;
    ComboBox<Byte> newAgeList;
    ComboBox<String> genderList;
    TextField newEmailField;
    TextField newPhoneNumField;
    TextField newAddressField;
    TextField newCountyField;
    ComboBox<String> newCountryList;
    TextField newPPSNumField;
    CheckBox isManager;

    public Scene setupCreateEmployeeScene() {

        // Initialise the pane and scene
        BorderPane createEmployeeRoot = new BorderPane();
        Scene createEmployeeScene = new Scene(createEmployeeRoot, 1280, 720);

        String[] countries = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
        
        // Width for all input fields to have
        final short itemWidth = 250;
        
        // Label setup
        Label newEmployeeHeading = new Label("Create new employee");
        newEmployeeHeading.setMaxWidth(itemWidth);
        newEmployeeHeading.setAlignment(Pos.CENTER);
        newEmployeeHeading = App.setFontSize(newEmployeeHeading, 20);

        // Input field setup
        newPinField = new TextField();
        newPinField.setPromptText("PIN *");
        newPinField.setMaxWidth(itemWidth);
        newPinField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //When focus lost
            	if (newPinField.getText().trim().isBlank()) {
            		newPinField.setText("");
            	}
            	else if(!newPinField.getText().matches("\\d{4}")){
                    newPinField.setText("");

                    AlertBox.notifyUser("Invalid Input", "Invalid pin entered. Must be 4 digits.");
                } else if (doesStaffMemberExist()) {
                    newPinField.setText("");

                    AlertBox.notifyUser("Invalid Input", "Invalid pin entered. This pin already exists.");
                }
            }
        });


        newFirstNameField = new TextField();
        newFirstNameField.setPromptText("First Name *");
        newFirstNameField.setMaxWidth(itemWidth);
        newFirstNameField = App.textFieldValidation(newFirstNameField, "[A-z]+", "Invalid first name entered. Must be only letters.");

        newLastNameField = new TextField();
        newLastNameField.setPromptText("Last Name *");
        newLastNameField.setMaxWidth(itemWidth);
        newLastNameField = App.textFieldValidation(newLastNameField, "[A-z]+", "Invalid last name entered. Must be only letters.");

        newAgeList = new ComboBox<>();
        for (byte i = 18; i < 100; i++) {
            newAgeList.getItems().add(i);
        }
        newAgeList.setPromptText("Select Age *");
        newAgeList.setMaxWidth(itemWidth);

        genderList = new ComboBox<>();
        genderList.getItems().addAll("Male", "Female");
        genderList.setPromptText("Select Gender *");
        genderList.setMaxWidth(itemWidth);

        newEmailField = new TextField();
        newEmailField.setPromptText("Email *");
        newEmailField.setMaxWidth(itemWidth);
        newEmailField = App.textFieldValidation(newEmailField, "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'" +
                "*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x" +
                "09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-" +
                "9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[" +
                "a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b" +
                "\\x0c\\x0e-\\x7f])+)\\])", "Invalid email format entered.");

        newPhoneNumField = new TextField();
        newPhoneNumField.setPromptText("Phone Number *");
        newPhoneNumField.setMaxWidth(itemWidth);
        newPhoneNumField = App.textFieldValidation(newPhoneNumField, "\\d{10}", "Invalid phone number format. Must be 10 digits.");

        newAddressField = new TextField();
        newAddressField.setPromptText("Address (1st line) *");
        newAddressField.setMaxWidth(itemWidth);
        newAddressField = App.textFieldValidation(newAddressField, "[A-z0-9\\s]+", "Invalid address format. Must be alpha-numeric only.");
        
        newCountyField = new TextField();
        newCountyField.setPromptText("County");
        newCountyField.setMaxWidth(itemWidth);
        newCountyField = App.textFieldValidation(newCountyField, "[A-z]+", "Invalid county entered. Must be only letters.");
        
        newCountryList = new ComboBox<>();
        newCountryList.setPromptText("Select Country");
        for (String country : countries) {
        	newCountryList.getItems().add(country);
        }
        newCountryList.setMaxWidth(itemWidth);

        newPPSNumField = new TextField();
        newPPSNumField.setPromptText("PPS Number *");
        newPPSNumField.setMaxWidth(itemWidth);
        newPPSNumField = App.textFieldValidation(newPPSNumField, "[0-9]{7}[A-z]{1,2}", "Invalid PPS number format. Must be 7 digits followed by 1 or 2 letters.");

        isManager = new CheckBox("Is a Manager?");

        // Create control buttons 
        HBox controlsGroup = new HBox(20);
        controlsGroup.setAlignment(Pos.CENTER);

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(e -> App.logoutBtnCode());

        Button createEmployeeBtn = new Button("Create");
        createEmployeeBtn.setOnAction(e -> createEmployeeBtnCode());

        controlsGroup.getChildren().addAll(cancelBtn, createEmployeeBtn);

        // Create a vbox to hold everything
        VBox employeeDetailsContainer = new VBox(20);
        employeeDetailsContainer.setAlignment(Pos.CENTER);
        employeeDetailsContainer.setMaxWidth(500);
        employeeDetailsContainer.getChildren().addAll(newEmployeeHeading, newPinField, newFirstNameField, newLastNameField, newAgeList,
                genderList, newEmailField, newPhoneNumField, newAddressField, newCountyField, newCountryList, newPPSNumField, isManager, controlsGroup);

        createEmployeeRoot.setCenter(employeeDetailsContainer);

        return createEmployeeScene;

    }

    // Function to check whether a staff member exists to ensure two staff members can have the same pin
    private boolean doesStaffMemberExist() {

        boolean staffMemberExists = false;
        byte i = 0;
        do {
            StaffMember staffMember = App.staffMembers[i];

            if (staffMember.getPin() == Short.parseShort(newPinField.getText())) {
                staffMemberExists = true;
            }

            i++;
        } while (!staffMemberExists && i < App.staffMembers.length);

        return staffMemberExists;

    }

    // Code for the create employee button to execute
    private void createEmployeeBtnCode() {

        if (newPinField.getText().trim().isEmpty() ||
                newFirstNameField.getText().trim().isEmpty() ||
                newLastNameField.getText().trim().isEmpty() ||
                newAgeList.getValue() == null ||
                genderList.getValue() == null ||
                newEmailField.getText().trim().isEmpty() ||
                newPhoneNumField.getText().trim().isEmpty() ||
                newAddressField.getText().trim().isEmpty() ||
                newPPSNumField.getText().trim().isEmpty())
        {
            AlertBox.notifyUser("Invalid Input", "Please fill in all required fields.\nRequired fields are marked *");
        } else {

            // Get the data needed to create a new staff member from the input fields
            short a = Short.parseShort(newPinField.getText());
            String b = newFirstNameField.getText();
            String c = newLastNameField.getText();
            byte d = newAgeList.getValue();
            String e = genderList.getValue();
            String f = newEmailField.getText();
            String g = newPhoneNumField.getText();
            String h = newCountyField.getText().isBlank() ? null : newCountyField.getText();
            String i = newCountryList.getValue();
            String j = newAddressField.getText();
            String k = newPPSNumField.getText();
            boolean l = isManager.isSelected();

            StaffMember newStaffMember = new StaffMember(a, b, c, d, e, f, g, h, i, j, k, l);

            // Add staff member to the existing array
            App.staffMembers = appendToStaffArray(App.staffMembers, newStaffMember);

            App.globalStage.setScene(App.loginScene);

            // Reset the scene
            App.createEmployeeScene = setupCreateEmployeeScene();

        }

    }

    // Function to add a new staff member to the end of the existing staff members array
    private StaffMember[] appendToStaffArray(StaffMember[] oldArray, StaffMember newStaffMember) {

    	// Create a new array 1 longer
        StaffMember[] newArray = new StaffMember[oldArray.length + 1];

        // Copy all data from the old array to the new array
        for (byte i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        // Add the new staff member to the last position
        newArray[oldArray.length] = newStaffMember;

        return newArray;

    }
    
}

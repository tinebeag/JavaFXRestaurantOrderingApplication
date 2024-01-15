package com.example.restaurantapp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PaymentScene {

	// Declare class members
    ToggleGroup paymentToggleGroup;
    TextField cardNumField;
    TextField cardExpiryField;
    TextField cardSecurityCodeField;
    VBox priceContainer;
    Label subtotalPriceLbl;
    Label serviceChargeLbl;
    Label vatLbl;
    Label totalPriceLbl;
    float totalPrice;
    boolean allCardFieldsValid;
    
    public Scene setupPaymentScene() {

        // Initialise the pane and scene
        BorderPane paymentRoot = new BorderPane();
        Scene paymentScene = new Scene(paymentRoot, 1280, 720);

        // Create the payment controls area
        VBox paymentOptionsContainer = new VBox(20);
        paymentOptionsContainer.setAlignment(Pos.CENTER);
        paymentOptionsContainer.setPrefWidth(500);
        
        Label paymentHeading = new Label("Payment");
        paymentHeading = App.setFontSize(paymentHeading, 40);
   
        // Create cash and card radio buttons
        paymentToggleGroup = new ToggleGroup();
        RadioButton cashBtn = new RadioButton("Cash");
        cashBtn.setUserData("Cash");
        RadioButton cardBtn = new RadioButton("Card");
        cardBtn.setUserData("Card");
        cardBtn.setSelected(true);

        cashBtn.setToggleGroup(paymentToggleGroup);
        cardBtn.setToggleGroup(paymentToggleGroup);

        // Width for card information text fields
        final short cardInfoFieldWidth = 200;

        // Create card information text fields
        cardNumField = new TextField();
        cardNumField.setPromptText("Card Number");
        cardNumField.setMaxWidth(cardInfoFieldWidth);
        cardNumField = App.textFieldValidation(cardNumField, "\\d{16}", "Invalid card number entered. Must be 16 digits.");

        cardExpiryField = new TextField();
        cardExpiryField.setPromptText("Card Expiry Date");
        cardExpiryField.setMaxWidth(cardInfoFieldWidth);
        cardExpiryField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // When focus lost     	
            	if (cardExpiryField.getText().trim().isBlank()) {
            		cardExpiryField.setText("");
            	}
            	else if(!cardExpiryField.getText().matches("[0-1][0-9]\\/[0-9]{2}") || !isValidMonth()){
                	cardExpiryField.setText(""); // Clear the text if it is invalid

                    AlertBox.notifyUser("Invalid Input", "Invalid expiry data entered. Must be in the format MM/YY.");
                }
            }
        });

        cardSecurityCodeField = new TextField();
        cardSecurityCodeField.setPromptText("Security Code");
        cardSecurityCodeField.setMaxWidth(cardInfoFieldWidth);
        cardSecurityCodeField = App.textFieldValidation(cardSecurityCodeField, "\\d{3}", "Invalid security code entered. Must be 3 digits.");

        HBox paymentControlsContainer = new HBox(20);
        paymentControlsContainer.setAlignment(Pos.CENTER);

        // Create add and submit payment buttons
        Button cancelPaymentBtn = new Button("Cancel Payment");
        cancelPaymentBtn.setOnAction(e -> cancelPaymentBtnCode());

        Button submitPaymentBtn = new Button("Submit Payment");
        submitPaymentBtn.setOnAction(e -> submitPaymentBtnCode());

        paymentControlsContainer.getChildren().addAll(cancelPaymentBtn, submitPaymentBtn);

        paymentOptionsContainer.getChildren().addAll(paymentHeading, cashBtn, cardBtn, cardNumField, cardExpiryField, cardSecurityCodeField, paymentControlsContainer);

        // Create the area for the order list to be shown
        priceContainer = new VBox(10);
        priceContainer.setAlignment(Pos.CENTER);
        priceContainer.setPrefWidth(500);

        Label orderHeading = new Label("Order Details");
        orderHeading = App.setFontSize(orderHeading, 30);

        // Creating the table and columns
        TableColumn<OrderListData, String> itemPriceColumn = new TableColumn<>("Item");
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("item"));

        TableColumn<OrderListData, String> quantityPriceColumn = new TableColumn<>("Quantity");
        quantityPriceColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<OrderListData, String> sizePriceColumn = new TableColumn<>("Price");
        sizePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        itemPriceColumn.setPrefWidth(130);
        quantityPriceColumn.setPrefWidth(130);
        sizePriceColumn.setPrefWidth(130);

        TableView<OrderListData> priceTable = new TableView<OrderListData>();
        priceTable.setMaxWidth(400);

        // Adding the order list and the columns to the table
        priceTable.setItems(App.menuSceneObj.orderList);
        priceTable.getColumns().addAll(itemPriceColumn, quantityPriceColumn, sizePriceColumn);

        // Setup the price text to be shown under the table
        Label serviceChargeNotice = new Label("Parties of 6 or more people must pay a 10% service charge.");
        subtotalPriceLbl = new Label("");
        subtotalPriceLbl = App.setFontSize(subtotalPriceLbl, 15);

        serviceChargeLbl = new Label("");
        serviceChargeLbl = App.setFontSize(serviceChargeLbl, 15);

        vatLbl = new Label("");
        vatLbl = App.setFontSize(vatLbl, 15);

        totalPriceLbl = new Label("");
        totalPriceLbl = App.setFontSize(totalPriceLbl, 20);

        priceContainer.getChildren().addAll(orderHeading, priceTable, serviceChargeNotice);

        // Create the hbox to hold the controls area and price table side by side
        HBox paymentHorizontalContainer = new HBox(100);
        paymentHorizontalContainer.setAlignment(Pos.CENTER);

        paymentHorizontalContainer.getChildren().addAll(paymentOptionsContainer, priceContainer);
        
        paymentRoot.setCenter(paymentHorizontalContainer);

        return paymentScene;

    }

    // Code for the submit payment button to execute
    private void submitPaymentBtnCode() {

        String paymentChoice = paymentToggleGroup.getSelectedToggle().toString();
        paymentChoice = paymentChoice.substring((paymentChoice.length() - 5), (paymentChoice.length() - 1));
        paymentChoice = paymentChoice.trim();

    	// Verify fields have been filled out if card is the option selected
        if (paymentChoice.charAt(3) == 'd' && (cardNumField.getText().trim().isEmpty() || cardExpiryField.getText().trim().isEmpty() || cardSecurityCodeField.getText().trim().isEmpty()))
        {
            AlertBox.notifyUser("Invalid Input", "Please fill in the card information fields or pay by cash.");
        } else {

            // Add this orders total price to todays total takings and update the manager takings screen
            App.managerTakingsSceneObj.daysTakings += totalPrice;
            App.managerTakingsSceneObj.daysTakingsLbl.setText(App.fmt.format(App.managerTakingsSceneObj.daysTakings));

            System.out.println(App.menuSceneObj.orderList + " sent to kitchen");
            
            App.menuScene = App.menuSceneObj.setupMenuScene();
            App.paymentScene = setupPaymentScene();

            AlertBox.notifyUser("Thank You", "Order Completed");

            App.globalStage.setScene(App.menuScene);

        }
    	
    }

    // Code for the cancel payment button to execute
    private void cancelPaymentBtnCode() {

    	App.globalStage.setScene(App.menuScene);

    }
    
    private boolean isValidMonth() {
    	
    	boolean isValidMonth = false;
    	
		char[] chars = new char[2];
		
		chars[0]= cardExpiryField.getText().trim().charAt(0);
		chars[1]= cardExpiryField.getText().trim().charAt(1);
		
		try {
			byte month = Byte.parseByte(String.copyValueOf(chars));
			
			if (month >= 1 && month <= 12) {
				isValidMonth = true;
			}
			
		} catch (Exception e){
			System.out.println("Invalid data entered for month");
			
		}
		
		return isValidMonth;
			
    }
	
}

package com.example.restaurantapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class MenuScene {

	// Declare class members
    ToggleGroup foodToggleGroup;
    ToggleGroup sizeToggleGroup;
    TextField quantityInput;
    TextArea notesArea;
    TableView<OrderListData> orderTable;
    ObservableList<OrderListData> orderList;
    
    public Scene setupMenuScene() {

        // Column padding
        final Insets columnPadding = new Insets(20, 0, 20, 50);

        // Initialise the pane and scene
        GridPane menuRoot = new GridPane();
        
        Scene menuScene = new Scene(menuRoot, 1280, 720);

        // Set row heights
        RowConstraints row1Constraints = new RowConstraints(0);
        row1Constraints.setPercentHeight(14);
        RowConstraints row2Constraints = new RowConstraints(0);
        row2Constraints.setPercentHeight(31);
        RowConstraints row3Constraints = new RowConstraints(0);
        row3Constraints.setPercentHeight(50);
        RowConstraints row4Constraints = new RowConstraints(0);
        row4Constraints.setPercentHeight(5);
        menuRoot.getRowConstraints().addAll(row1Constraints, row2Constraints, row3Constraints, row4Constraints);

        // Add column width constraints for 3 rows
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100 / 3.0);
        for(byte i = 0; i < 3; i++) {
            menuRoot.getColumnConstraints().add(columnConstraints);
        }

        // Setup headings
        Label breakfastHeading = new Label("Breakfast");
        breakfastHeading.setPadding(columnPadding);
        breakfastHeading = App.setFontSize(breakfastHeading, 40);

        Label lunchHeading = new Label("Lunch");
        lunchHeading.setPadding(columnPadding);
        lunchHeading = App.setFontSize(lunchHeading, 40);

        Label dinnerHeading = new Label("Dinner");
        dinnerHeading.setPadding(columnPadding);
        dinnerHeading = App.setFontSize(dinnerHeading, 40);

        menuRoot.add(breakfastHeading, 0, 0);
        menuRoot.add(lunchHeading, 1, 0);
        menuRoot.add(dinnerHeading, 2, 0);

        // Setup menu columns
        foodToggleGroup = new ToggleGroup();

        // Create breakfast items and their container
        FoodItem porridge = new FoodItem("Porridge", 1.50f);
        RadioButton porridgeBtn = new RadioButton(porridge.getName());
        porridgeBtn.setUserData(porridge);
        porridgeBtn.setSelected(true);
        FoodItem cornflakes = new FoodItem("Cornflakes", 2.00f);
        RadioButton cornflakesBtn = new RadioButton(cornflakes.getName());
        cornflakesBtn.setUserData(cornflakes);
        FoodItem weetabix = new FoodItem("Weetabix", 1.85f);
        RadioButton weetabixBtn = new RadioButton(weetabix.getName());
        weetabixBtn.setUserData(weetabix);
        FoodItem fullIrish = new FoodItem("Full Irish", 5.40f);
        RadioButton fullIrishBtn = new RadioButton(fullIrish.getName());
        fullIrishBtn.setUserData(fullIrish);

        porridgeBtn.setToggleGroup(foodToggleGroup);
        cornflakesBtn.setToggleGroup(foodToggleGroup);
        weetabixBtn.setToggleGroup(foodToggleGroup);
        fullIrishBtn.setToggleGroup(foodToggleGroup);

        VBox breakfastMenu = new VBox(30);
        breakfastMenu.setPadding(columnPadding);

        breakfastMenu.getChildren().addAll(porridgeBtn, cornflakesBtn, weetabixBtn, fullIrishBtn);

        menuRoot.add(breakfastMenu, 0, 1);

        // Create lunch items and their container
        FoodItem sandwich = new FoodItem("Sandwich", 3.20f);
        RadioButton sandwichBtn = new RadioButton(sandwich.getName());
        sandwichBtn.setUserData(sandwich);
        FoodItem salad = new FoodItem("Salad", 2.50f);
        RadioButton saladBtn = new RadioButton(salad.getName());
        saladBtn.setUserData(salad);
        FoodItem soup = new FoodItem("Soup", 2.80f);
        RadioButton soupBtn = new RadioButton(soup.getName());
        soupBtn.setUserData(soup);
        FoodItem omelette = new FoodItem("Omelette", 3.00f);
        RadioButton omeletteBtn = new RadioButton(omelette.getName());
        omeletteBtn.setUserData(omelette);

        sandwichBtn.setToggleGroup(foodToggleGroup);
        saladBtn.setToggleGroup(foodToggleGroup);
        soupBtn.setToggleGroup(foodToggleGroup);
        omeletteBtn.setToggleGroup(foodToggleGroup);

        VBox lunchMenu = new VBox(30);
        lunchMenu.setPadding(columnPadding);

        lunchMenu.getChildren().addAll(sandwichBtn, saladBtn, soupBtn, omeletteBtn);

        menuRoot.add(lunchMenu, 1, 1);

        // Create lunch items and their container
        FoodItem roastChicken = new FoodItem("Roast Chicken", 6.25f);
        RadioButton roastChickenBtn = new RadioButton(roastChicken.getName());
        roastChickenBtn.setUserData(roastChicken);
        FoodItem gammon = new FoodItem("Gammon", 5.95f);
        RadioButton gammonBtn = new RadioButton(gammon.getName());
        gammonBtn.setUserData(gammon);
        FoodItem curry = new FoodItem("Curry", 5.45f);
        RadioButton curryBtn = new RadioButton(curry.getName());
        curryBtn.setUserData(curry);
        FoodItem stirFry = new FoodItem("Stir-Fry", 5.15f);
        RadioButton stirFryBtn = new RadioButton(stirFry.getName());
        stirFryBtn.setUserData(stirFry);

        roastChickenBtn.setToggleGroup(foodToggleGroup);
        gammonBtn.setToggleGroup(foodToggleGroup);
        curryBtn.setToggleGroup(foodToggleGroup);
        stirFryBtn.setToggleGroup(foodToggleGroup);

        VBox dinnerMenu = new VBox(30);
        dinnerMenu.setPadding(columnPadding);

        dinnerMenu.getChildren().addAll(roastChickenBtn, gammonBtn, curryBtn, stirFryBtn);

        menuRoot.add(dinnerMenu, 2, 1);

        // Create size and quantity controls area
        HBox sizeAndQuantityGroup = new HBox(100);

        // Create size heading and radio buttons
        VBox sizeGroup = new VBox(20);

        Label sizeHeading = new Label("Portion Size");
        sizeHeading = App.setFontSize(sizeHeading, 20);

        sizeToggleGroup = new ToggleGroup();
        RadioButton smallBtn = new RadioButton("Small");
        smallBtn.setUserData("Small");
        RadioButton regularBtn = new RadioButton("Regular");
        regularBtn.setSelected(true);
        regularBtn.setUserData("Regular");
        RadioButton largeBtn = new RadioButton("Large");
        largeBtn.setUserData("Large");

        smallBtn.setToggleGroup(sizeToggleGroup);
        regularBtn.setToggleGroup(sizeToggleGroup);
        largeBtn.setToggleGroup(sizeToggleGroup);

        sizeGroup.getChildren().addAll(sizeHeading, smallBtn, regularBtn, largeBtn);

        // Create quantity input
        VBox quantityGroup = new VBox(20);

        Label quantityLabel = new Label("Enter Quantity");
        quantityLabel = App.setFontSize(quantityLabel, 20);

        quantityInput = new TextField();
        quantityInput.setText("1");
        quantityInput.setPrefWidth(100);
        quantityInput.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // When focus lost
            	if (quantityInput.getText().trim().isBlank()) {
            		quantityInput.setText("1");
            	}
            	else if((!quantityInput.getText().matches("[0-9]{1,2}")) || (quantityInput.getText().trim().charAt(0) == '0')){
                	quantityInput.setText(""); // Clear the text if it is invalid

                    AlertBox.notifyUser("Invalid Input", "Invalid quantity entered. Must be 1 - 99");
                }
            }
        });
        
        quantityGroup.getChildren().addAll(quantityLabel, quantityInput);

        sizeAndQuantityGroup.getChildren().addAll(sizeGroup, quantityGroup);

        // Create the notes text box
        notesArea = new TextArea();
        notesArea.setPromptText("Notes");
        notesArea.setWrapText(true);
        notesArea.setPrefHeight(80);
        notesArea.setMaxWidth(280);

        // Create the add, remove and send to kitchen buttons
        Button addItemBtn = new Button("Add Item");
        addItemBtn.setOnAction(e -> addItemBtnCode());

        Button removeItemBtn = new Button("Remove Item");
        removeItemBtn.setOnAction(e -> removeItemBtnCode());

        Button goToPaymentBtn = new Button("Go To Payment");
        goToPaymentBtn.setOnAction(e -> goToPaymentBtnCode());

        // Assign the add, remove and send to kitchen buttons to their hbox
        HBox itemControlsGroup = new HBox(20);
        itemControlsGroup.getChildren().addAll(addItemBtn, removeItemBtn, goToPaymentBtn);

        // Create the menu area and add all the controls
        VBox menuControlsArea = new VBox(20);
        menuControlsArea.setPadding(columnPadding);
        menuControlsArea.getChildren().addAll(sizeAndQuantityGroup, notesArea, itemControlsGroup);

        menuRoot.add(menuControlsArea, 0, 2);

        // Create the list section that will show the order as items are added
        orderTable = new TableView<OrderListData>();

        // Creating the table and columns
        TableColumn<OrderListData, String> itemColumn = new TableColumn<>("Item");
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));

        TableColumn<OrderListData, String> sizeColumn = new TableColumn<>("Size");
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

        TableColumn<OrderListData, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<OrderListData, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<OrderListData, String> notesColumn = new TableColumn<>("Notes");
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));

        itemColumn.setPrefWidth(100);
        sizeColumn.setPrefWidth(100);
        quantityColumn.setPrefWidth(80);
        priceColumn.setPrefWidth(80);
        notesColumn.setPrefWidth(490);

        // Initialising the order list
        orderList = FXCollections.observableArrayList();

        // Adding the order list and the columns to the table
        orderTable.setItems(orderList);
        orderTable.getColumns().addAll(itemColumn, sizeColumn, quantityColumn, priceColumn, notesColumn);

        menuRoot.add(orderTable, 1, 2, 2, 2);

        // Create logout and help button
        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> App.logoutBtnCode());

        Button helpBtn = new Button("Help");
        helpBtn.setOnAction(e -> AlertBox.showHelpScreen("Items from the menu can be selected by clicking on the radio button next to them.\nA portion size can be selected on the left by choosing from the 3 radio buttons.\nA quantity of the selected item can be chosen by entering a number in the text box.\nOptionally, notes for the chef can be added in the text field below.\nFinally press the button labeled \"Add Item\" to add this item to the list.\nYou will see the item appear in the list area on the right.\nAt any time an item in the list can be clicked on and the \"Remove Item\" button pressed to remove it from the order.\nWhen the order is complete press the \"Go to Payment\" button to complete the order and pay."));

        HBox logoutAndHelpContainer = new HBox(320);
        logoutAndHelpContainer.getChildren().addAll(logoutBtn, helpBtn);
        logoutAndHelpContainer.setAlignment(Pos.CENTER);

        menuRoot.add(logoutAndHelpContainer, 0, 3);

        return menuScene;

    }

    // Code for the add item button to execute
    private void addItemBtnCode() {

    	// Get the selections from the radio buttons and text fields in the menu
        FoodItem itemToAdd = (FoodItem) foodToggleGroup.getSelectedToggle().getUserData();

        String itemName = itemToAdd.getName();

        String size = sizeToggleGroup.getSelectedToggle().getUserData().toString();

        byte quantity = Byte.parseByte(quantityInput.getText());

        float price = itemToAdd.getPrice();

        String notes = notesArea.getText();

        // Create the entry in the list
        orderList.add(new OrderListData(itemName, size, quantity, App.fmt.format(price * quantity), notes));
        
        // Reset quantity and notes
        quantityInput.setText("1");
        notesArea.clear();

    }

    // Code for the remove item button to execute
    private void removeItemBtnCode() {

        orderTable.getItems().removeAll(orderTable.getSelectionModel().getSelectedItems());

    }

    // Code for the send to kitchen button to execute
    private void goToPaymentBtnCode() {

    	if (orderList.isEmpty()) {
    		AlertBox.notifyUser("Invalid Order", "Your order is empty. Please add items to proceed.");
    	} else {
    		
    		// Get confirmation to send to kitchen
            boolean goToPayment = AlertBox.showAlertWithConfirmation("Confirm Action", "Are you sure you want to proceed to payment?", "Yes");

            if (goToPayment) {

                // Loop through all order list items and add up the cost
                float subtotalPrice = 0;
                App.paymentSceneObj.totalPrice = 0;
                int itemQuantity = 0;
                for (OrderListData item : orderList) {
                    // Get the formatted price string and remove the euro sign added by the format
                    String stringPrice = item.getPrice();
                    stringPrice = stringPrice.substring(1);

                    float itemPrice = Float.parseFloat(stringPrice);
                    itemQuantity += item.getQuantity();

                    subtotalPrice += itemPrice;

                }

                // This fixes a crash that would occur if you added items, sent to kitchen, canceled payment and then sent
                // the order again. This is because duplicated children were being added to price container. So if the price
                // container contains more than 3 children (which is the starting number) this removes all but the first 3 children
                int priceContainerElements = App.paymentSceneObj.priceContainer.getChildren().size();
                if (priceContainerElements > 3) {

                    for (int i = priceContainerElements - 1; i > 2; i--) {
                        App.paymentSceneObj.priceContainer.getChildren().remove(i);
                    }

                }

                final float vatRate = 0.23f;
                float vat;
                vat = subtotalPrice * vatRate;
                // Apply service charge for tables of 6 or more
                if (itemQuantity >= 6) {
                	float serviceCharge;
                	
                	serviceCharge = subtotalPrice * 0.1f;
                	
                	App.paymentSceneObj.totalPrice = subtotalPrice + vat + serviceCharge;

                	App.paymentSceneObj.subtotalPriceLbl.setText("Subtotal: " + App.fmt.format(subtotalPrice));
                	App.paymentSceneObj.serviceChargeLbl.setText("Service Charge: " + App.fmt.format(serviceCharge));
                	App.paymentSceneObj.vatLbl.setText("Vat: " + App.fmt.format(vat));
                	App.paymentSceneObj.totalPriceLbl.setText("Total Price: " + App.fmt.format(App.paymentSceneObj.totalPrice));

                	App.paymentSceneObj.priceContainer.getChildren().addAll(App.paymentSceneObj.subtotalPriceLbl, App.paymentSceneObj.serviceChargeLbl, App.paymentSceneObj.vatLbl, App.paymentSceneObj.totalPriceLbl);
                } else {
                	// No service charge being applied
                	App.paymentSceneObj.totalPrice = subtotalPrice + vat;
                	
                	App.paymentSceneObj.subtotalPriceLbl.setText("Subtotal: " + App.fmt.format(subtotalPrice));
                	App.paymentSceneObj.vatLbl.setText("Vat: " + App.fmt.format(vat));
                	App.paymentSceneObj.totalPriceLbl.setText("Total Price: " + App.fmt.format(App.paymentSceneObj.totalPrice));

                	App.paymentSceneObj.priceContainer.getChildren().addAll(App.paymentSceneObj.subtotalPriceLbl, App.paymentSceneObj.vatLbl, App.paymentSceneObj.totalPriceLbl);
                }


                App.globalStage.setScene(App.paymentScene);


            } else {

                System.out.println("Action cancelled");

            }
            
    	}

    }
	
}

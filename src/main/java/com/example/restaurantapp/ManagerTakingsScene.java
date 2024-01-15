package com.example.restaurantapp;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ManagerTakingsScene {

	// Declare class members
    Label daysTakingsLbl;
    float daysTakings;
    
    public Scene setupManagerTakingsScene() {
    	
    	daysTakings = 0;

        // Initialise the pane and scene
        BorderPane managerTakingsRoot = new BorderPane();
        Scene createEmployeeScene = new Scene(managerTakingsRoot, 1280, 720);

        // Setup the headings and days takings display
        Label heading = new Label("Manager Portal");
        heading.setMaxWidth(300);
        heading.setAlignment(Pos.CENTER);
        heading = App.setFontSize(heading, 40);

        Label subHeading = new Label("Today's Takings");
        subHeading.setMaxWidth(300);
        subHeading.setAlignment(Pos.CENTER);
        subHeading = App.setFontSize(subHeading, 30);

        daysTakingsLbl = new Label();
        daysTakingsLbl.setMaxWidth(300);
        daysTakingsLbl.setAlignment(Pos.CENTER);
        daysTakingsLbl = App.setFontSize(daysTakingsLbl, 20);
        daysTakingsLbl.setText(App.fmt.format(daysTakings));

        // Logout button
        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> App.logoutBtnCode());

        Button toMenuBtn = new Button("Go To Menu Screen");
        toMenuBtn.setOnAction(e -> toMenuBtnCode());

        // Vbox to hold everything
        VBox container = new VBox(50);
        container.setAlignment(Pos.CENTER);
        container.setMaxWidth(500);
        container.getChildren().addAll(heading, subHeading, daysTakingsLbl, logoutBtn, toMenuBtn);

        managerTakingsRoot.setCenter(container);

        return createEmployeeScene;

    }

    private void toMenuBtnCode() {

        App.globalStage.setScene(App.menuScene);

    }
}

package com.example.restaurantapp;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class AlertBox {

    static boolean hasConfirmedAction;

    // Show the send to kitchen confirmation alert box
    public static boolean showAlertWithConfirmation(String windowTitle, String alertMsg, String confirmBtnMsg) {

        hasConfirmedAction = false;

        Stage window = new Stage();
        window.setTitle(windowTitle);
        window.setMinHeight(250);
        window.setMinWidth(475);

        window.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label(alertMsg);

        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(e -> window.close());

        Button confirmBtn = new Button(confirmBtnMsg);
        confirmBtn.setOnAction(e -> {
            hasConfirmedAction = true;
            window.close();
        });

        buttons.getChildren().addAll(cancelBtn, confirmBtn);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, buttons);
        layout.setAlignment(Pos.CENTER);

        // Display window and wait
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return hasConfirmedAction;

    }

    // Show the general notification alert box
    public static void notifyUser(String title, String msg) {

		Stage window = new Stage();
		window.setTitle(title);
		window.setMinHeight(250);
		window.setMinWidth(400);
		
		window.initModality(Modality.APPLICATION_MODAL);
		Label label = new Label(msg);
		
		Button confirmBtn = new Button("OK");
		confirmBtn.setOnAction(e -> {
		    window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, confirmBtn);
		layout.setAlignment(Pos.CENTER);
		
		// Display window and wait
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

    }

    public static void showHelpScreen(String info) {

        Stage window = new Stage();
        window.setTitle("Help");
        window.setMinHeight(500);
        window.setMinWidth(750);

        window.initModality(Modality.APPLICATION_MODAL);

        Label heading = new Label("Menu Help");
        heading = App.setFontSize(heading, 30);

        Label text = new Label(info);

        Button confirmBtn = new Button("OK");
        confirmBtn.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(50);
        layout.getChildren().addAll(heading, text, confirmBtn);
        layout.setAlignment(Pos.CENTER);

        // Display window and wait
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

}
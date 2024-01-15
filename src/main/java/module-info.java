module com.example.skillsdemo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restaurantapp to javafx.fxml;
    exports com.example.restaurantapp;
}
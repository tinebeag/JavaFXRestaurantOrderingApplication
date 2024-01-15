package com.example.restaurantapp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class OrderListData {

    public String getItem() {
        return item.get();
    }

    public SimpleStringProperty itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }

    public String getSize() {
        return size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getNotes() {
        return notes.get();
    }

    public SimpleStringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    private SimpleStringProperty item;
    private SimpleStringProperty size;
    private SimpleIntegerProperty quantity;
    private SimpleStringProperty price;
    private SimpleStringProperty notes;


    public OrderListData(String item, String size, byte quantity, String price, String notes) {
        this.item = new SimpleStringProperty(item);
        this.size = new SimpleStringProperty(size);
        this.quantity = new SimpleIntegerProperty(quantity);;
        this.price = new SimpleStringProperty(price);
        this.notes = new SimpleStringProperty(notes);
    }

}

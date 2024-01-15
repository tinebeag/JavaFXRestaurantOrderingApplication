package com.example.restaurantapp;

public class FoodItem {

    private String name;
    private float price;

    public FoodItem(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}

package com.example.restaurantapp;

public class StaffMember {

    private short pin;
    private String firstName;
    private String lastName;
    private byte age;
    private String gender;
    private String email;
    private String phoneNum;
    private String address;
    private String county;
    private String country;
    private String PPSNum;
    private boolean isManager;

    public StaffMember(short pin,
                       String firstName,
                       String lastName,
                       byte age,
                       String gender,
                       String email,
                       String phoneNum,
                       String address,
                       String county,
                       String country,
                       String PPSNum,
                       boolean isManager) {

        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.county = county;
        this.country = country;
        this.PPSNum = PPSNum;
        this.isManager = isManager;

    }

    public short getPin() {
        return pin;
    }

    public boolean isManager() {
        return isManager;
    }

}

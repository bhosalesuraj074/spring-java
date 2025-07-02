package com.springcore;

public class UPI implements Payment{
    private int phoneNumber;
    private String name;
    private String password;

    public UPI() {
    }

    public UPI(int phoneNumber, String name, String password) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void processPayment() {
        System.out.println("$------------- welcome to UPI -------------$");
        System.out.println("Phone Number: "+ this.getPhoneNumber());
        System.out.println("User Name: "+ this.getName());
        System.out.println("Password: "+ this.getPassword());

    }
}

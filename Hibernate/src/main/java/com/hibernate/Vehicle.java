package com.hibernate;

public class Vehicle {
    private String vehicleId;
    private String model;
    private String vehicleName;
    private String year;
    private double price;

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String model, String vehicleName, String year, double price) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.vehicleName = vehicleName;
        this.year = year;
        this.price = price;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

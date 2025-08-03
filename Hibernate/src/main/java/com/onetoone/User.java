package com.onetoone;

public class User {
    private int id;
    private String userName;
    private Address address;

    public User(int id, String userName, Address address) {
        this.id = id;
        this.userName = userName;
        this.address = address;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

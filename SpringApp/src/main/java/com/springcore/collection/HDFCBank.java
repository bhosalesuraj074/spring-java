package com.springcore.collection;

import java.util.Objects;

public class HDFCBank implements Bank{


    private final static String bankName = "HDFCBank";
    private String username;
    private String password;
    private String firstName;
    private  String lastName;
    private String email;
    private  double amount;

    public HDFCBank() {
        System.out.println("$ --- Welcome to HDFC Bank --- $");
    }

    public HDFCBank(String username, String password, String firstName, String lastName, String email, double amount) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.amount = amount;
    }
    public static String getBankName() {
        return bankName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void register() {
        System.out.println("Registration page -----------------> ");
        System.out.println("Bank Name: "+ getBankName());
        System.out.println("Username: "+ this.getUsername());
        System.out.println("Password: "+ this.getPassword());
        System.out.println("FirstName: "+ this.getFirstName());
        System.out.println("LastName: "+ this.getLastName());
        System.out.println("Email: "+ this.getEmail());
        System.out.println("Amount: "+ this.getAmount());

    }

    @Override
    public void login() {
        System.out.println("Login page -------------------> ");
        System.out.println("Username: "+ this.getUsername());
        System.out.println("Password: "+ this.getPassword());

    }

    @Override
    public void deposit() {
        System.out.println("deposit page -----------------> ");
        System.out.println("Username: "+ this.getUsername());
        System.out.println("Deposit: "+ this.getAmount());

    }

    @Override
    public void withdraw() {
        System.out.println("deposit page ----------------> ");
        System.out.println("Username: "+ this.getUsername());
        System.out.println("Deposit: "+ this.getAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HDFCBank hdfcBank = (HDFCBank) o;
        return Double.compare(amount, hdfcBank.amount) == 0 && Objects.equals(username, hdfcBank.username) && Objects.equals(password, hdfcBank.password) && Objects.equals(firstName, hdfcBank.firstName) && Objects.equals(lastName, hdfcBank.lastName) && Objects.equals(email, hdfcBank.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, email, amount);
    }

    @Override
    public String toString() {
        return "HDFCBank{" +
                "bankName='" + bankName + '\'' +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", amount=" + amount +
                '}';
    }
}

package com.springcore;

public class NetBanking implements Payment{


    private String userName;
    private long accountNumber ;
    private String bankName;
    private String phoneNumber;


    public NetBanking (){}

    public NetBanking(String userName, long accountNumber, String bankName, String phoneNumber) {
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.phoneNumber = phoneNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public void processPayment() {
        System.out.println("$------------- welcome to Net-Banking -------------$");
        System.out.println("User Name: "+ this.getUserName());
        System.out.println("Account Number: "+ this.getAccountNumber());
        System.out.println("Bank Name: "+ this.getBankName());
        System.out.println("Phone Number: "+ this.getPhoneNumber());

    }
}

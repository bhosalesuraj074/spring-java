package com.springcore;

import java.time.LocalDate;


public class CreditCard implements Payment{
    private long creditCardNo;
    private String bankName;
    private String cardHolderName;
    private LocalDate date;

    public CreditCard() {
    }

    public CreditCard(long creditCardNo, String bankName, String cardHolderName, LocalDate date) {
        this.creditCardNo = creditCardNo;
        this.bankName = bankName;
        this.cardHolderName = cardHolderName;
        this.date = LocalDate.now();
    }

    public long getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(long creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        System.out.println(date);
        this.date = LocalDate.now();
    }


    @Override
    public void processPayment() {
        System.out.println("\n" +"$------------- welcome to Credit card payment -------------$");
        System.out.println("Credit Card Number: "+ this.getCreditCardNo());
        System.out.println("Bank Name: "+ this.getBankName());
        System.out.println("Card Holder Name: "+ this.getCardHolderName());
        System.out.println("Date of transaction: "+ this.getDate());
    }
}

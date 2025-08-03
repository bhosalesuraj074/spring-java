package com.billing;

import java.time.LocalDate;

public class BillingDetails {
    private long id;
    private String owner;
    private String mobileNumber;
    private LocalDate date;

    public BillingDetails() {
    }

    public BillingDetails(long id, String owner, String CCNumber, LocalDate date) {
        this.id = id;
        this.owner = owner;
        this.mobileNumber = CCNumber;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

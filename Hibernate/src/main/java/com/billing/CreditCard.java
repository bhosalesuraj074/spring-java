package com.billing;

import java.time.LocalDate;

public class CreditCard  extends BillingDetails{
    private String id;
    private String type;
    private String expMonth;
    private String expYear;

    public CreditCard(){}

    public CreditCard(String id, String type, String expMonth, String expYear) {
        this.id = id;
        this.type = type;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public CreditCard(long id, String owner, String number, LocalDate date, String id1, String type, String expMonth, String expYear) {
        super(id, owner, number, date);
        this.id = id1;
        this.type = type;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
}

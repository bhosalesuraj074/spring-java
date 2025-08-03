package com.billing;

import java.time.LocalDate;

public class BankDetails extends BillingDetails {

    private String bankName;
    private String accountNumber;

    public BankDetails() {
    }

    public BankDetails( String bankName, String accountNumber) {

        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public BankDetails(long id, String owner, String number, LocalDate date, String bankName, String accountNumber) {
        super(id, owner, number, date);

        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

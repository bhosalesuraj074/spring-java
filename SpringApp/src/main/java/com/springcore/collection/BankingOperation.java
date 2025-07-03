package com.springcore.collection;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BankingOperation {
  //List<Bank> bank;
  //Set<Bank> bank;
    Map<String, Bank> bank;


    public BankingOperation() {
    }

    public BankingOperation(Map<String, Bank> bank) {
        this.bank = bank;
    }

    public Map<String, Bank>  getBank() {
        return bank;
    }

    public void setBank(Map<String, Bank> bank) {
        this.bank = bank;
    }
}

package com.springcore.vehicle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bike")
public class Bike implements Vehicle{
    @Value("Honda")
    private String bikeName;

    public Bike() {
    }

    @Override
    public void drive() {
        System.out.println("Driving the Bike...");
        System.out.println(bikeName);
    }
}

package com.springcore.vehicle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("plane")
public class Plane implements Vehicle{
    @Value("Air India")
    private String planeName;

    public Plane() {
    }



    @Override
    public void drive() {
        System.out.println("Driving Plane...");
        System.out.println(planeName);
    }
}

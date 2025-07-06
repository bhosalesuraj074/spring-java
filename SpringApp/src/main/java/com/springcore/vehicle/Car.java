package com.springcore.vehicle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car")
public class Car implements  Vehicle{
    @Value("Volvo")
    private String carName;

    public Car() {
    }

    @Override
    public void drive() {
        System.out.println("Driving a car...");
        System.out.println(carName);
    }
}

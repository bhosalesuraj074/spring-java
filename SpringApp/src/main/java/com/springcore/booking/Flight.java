package com.springcore.booking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("flight")
public class Flight implements Notification{
    @Value("Flight")
    private  String flight;

    public Flight() {
    }

    public Flight(String flight){
        this.flight = flight;
    }

    @Override
    public void ConfirmTicket() {
        System.out.println("Flight Booking Confirmed ...");
        System.out.println(flight);
    }
}

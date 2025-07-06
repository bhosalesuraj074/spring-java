package com.springcore.booking;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springcore")
public class BookingConfig {
    public BookingService bookingService(){
        return  new BookingService();
    }
    public Flight flight(){
        return  new Flight();
    }
    public Train train(){
        return  new Train();
    }
}

package com.springcore.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bookingService")
public class BookingService{

    private Notification notification;

    public BookingService() {
    }

    public Notification getNotification() {
        return notification;
    }

    @Autowired
    @TravelMode(value = "train")
    public void setNotification(Notification notification) {
        this.notification = notification;
    }




}

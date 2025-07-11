package com.springcore.booking;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("booking.xml");*/
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(BookingConfig.class);
        BookingService bookingService = (BookingService) applicationContext.getBean("bookingService");
        bookingService.getNotification().ConfirmTicket();
    }
}

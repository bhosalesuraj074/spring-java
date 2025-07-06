package com.springcore.vehicle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("vehicle.xml");
        Drive drive = applicationContext.getBean(Drive.class);
        drive.start();
    }
}

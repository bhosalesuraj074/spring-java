package com.springcore.sport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext  =  new ClassPathXmlApplicationContext("sport.xml");
        Coach coach = applicationContext.getBean(Coach.class);
        coach.getSport().display();
    }
}

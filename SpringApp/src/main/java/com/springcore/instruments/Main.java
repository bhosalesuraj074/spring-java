package com.springcore.instruments;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory =  new ClassPathXmlApplicationContext("instrument.xml");

        PlayInstruments playInstruments= beanFactory.getBean("playInstrument", PlayInstruments.class);
        System.out.println(playInstruments);
        System.out.println(beanFactory.getBean("playInstrument", PlayInstruments.class));
        System.out.println(beanFactory.getBean("playInstrument", PlayInstruments.class));
        System.out.println(beanFactory.getBean("playInstrument", PlayInstruments.class));
        System.out.println(beanFactory.getBean("playInstrument", PlayInstruments.class));
        playInstruments.getInstrument().play();
    }
}

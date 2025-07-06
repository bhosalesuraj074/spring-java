package com.springcore.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        BeanFactory bean = new ClassPathXmlApplicationContext("autowireannotation.xml");
        /*PersonInfo person = bean.getBean("personInfo", PersonInfo.class);*/
        PersonInfo person = bean.getBean(PersonInfo.class);
        person.getPerson().display();



    }
}

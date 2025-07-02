package com.springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        OrderProcess orderProcess= (OrderProcess)  beanFactory.getBean("orderProcess");
        orderProcess.getPaymentMode().processPayment();
        System.out.println(orderProcess.getOrder());

    }
}

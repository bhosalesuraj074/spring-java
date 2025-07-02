package com.springcore.collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BeanFactory bean = new ClassPathXmlApplicationContext("CollectionBank.xml");
        BankingOperation bankingOperation = (BankingOperation) bean.getBean("bankingOperation");
        Map<String, Bank> banks = bankingOperation.getBank();
        for (Map.Entry<String, Bank> bank : banks.entrySet()){
            System.out.println(bank);
        }
        /*for (Bank bank: banks){
            bank.register();
            bank.login();
            bank.deposit();
            bank.withdraw();
        }*/

       /* System.out.println("List Count: "+ banks.size());

        Map<Boolean, List<Bank>> collect = banks
                .stream()
                .collect(Collectors.partitioningBy(bank -> bank.getClass().getName().equals("com.springcore.collection.HDFCBank")));
        System.out.println(collect.get(true));
        System.out.println(collect.get(false));*/


        // working with props
        BeanFactory propBean = new ClassPathXmlApplicationContext("propsBean.xml");
        PropsExample propsExample= (PropsExample) propBean.getBean("propBean");
        Set<Map.Entry<Object, Object>> entries = propsExample.getProperties().entrySet();
        for (Map.Entry<Object, Object> obj : propsExample.getProperties().entrySet()){
            System.out.println("Key: "+obj.getKey());
            System.out.println("Value: "+ obj.getValue());
        }

    }

}

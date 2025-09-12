package com.kafka.services;

import com.kafka.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class KafkaListener {

    public  static  final Logger LOGGER = LoggerFactory.getLogger(KafkaListener.class);
//    @org.springframework.kafka.annotation.KafkaListener(topics = "kafka-topic", groupId = "kafka")
//    public void consumer(String message){
//        System.out.println("Consumer message ->  "+ message);
//
//    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "kafka-topic", groupId = "kafka")
    public  void consumeUser(User user){
//        System.out.println();
        LOGGER.info(String.format("Consumed user : %s",  user));

    }



}

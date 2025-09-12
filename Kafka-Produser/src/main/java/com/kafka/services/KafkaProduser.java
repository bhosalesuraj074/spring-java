package com.kafka.services;

import com.kafka.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProduser {
    @Autowired
    private KafkaTemplate<String, Object> kafka;

    public String produceMessage(String message){
        CompletableFuture<SendResult<String, Object>> future = kafka.send("kafka-topic", message);
        try {
            return "Message delivered successfully into " + future.get().getRecordMetadata().topic()+ " topic";
        }
        catch (Exception ex){
            return "Failed to send the message";
        }

    }

    public String sendUserDetails(User user){
        CompletableFuture<SendResult<String, Object>> future= kafka.send("kafka-topic", user);
        try {
            return "user data transferred" + future.get().getRecordMetadata().topic();
        }catch (Exception exception){
            return  "failed to send the data";
        }
    }

}

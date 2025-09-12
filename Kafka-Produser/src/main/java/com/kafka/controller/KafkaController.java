package com.kafka.controller;

import com.kafka.dto.User;
import com.kafka.services.KafkaProduser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
public class KafkaController {
    @Autowired
    private KafkaProduser produser;

    @GetMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message){
         return ResponseEntity.ok(produser.produceMessage(message));
    }

    @PostMapping
    public String sendUser(@RequestBody User user){
        return produser.sendUserDetails(user);
    }

}

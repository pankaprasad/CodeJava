package com.codejava.kafkaproducer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class kafkaProducerController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    static int i = 0;

    @GetMapping("/send")
    public void sendMessage() {
        kafkaTemplate.send("kafka-producer","Hello sending data :"+i);
        i++;
    }
}

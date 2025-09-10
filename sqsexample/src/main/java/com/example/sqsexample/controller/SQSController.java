package com.example.sqsexample.controller;

import com.example.sqsexample.config.SQSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSController {

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @GetMapping("/sendMsg")
    public void sndMsg() {
        //sqsConfig.sendMsg();
        queueMessagingTemplate.send( "https://sqs.eu-north-1.amazonaws.com/018503853785/SQSexample",MessageBuilder.withPayload("\"This is testing from Spring Boot Application\"").build());
    }
}

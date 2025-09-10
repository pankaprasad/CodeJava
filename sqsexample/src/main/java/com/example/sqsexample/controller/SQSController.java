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

    @Value("${cloud.aws.endpoint.uri}")
    String queueUrl;

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @GetMapping("/sendMsg/{message}")
    public void sndMsg() {
        //sqsConfig.sendMsg();
        queueMessagingTemplate.send( queueUrl,MessageBuilder.withPayload(message).build());
    }
}

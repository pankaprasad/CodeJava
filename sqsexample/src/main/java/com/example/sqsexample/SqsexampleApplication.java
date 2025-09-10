package com.example.sqsexample;

import com.example.sqsexample.config.SQSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication
public class SqsexampleApplication {

    @Autowired
    SQSConfig sqsConfig;

	public static void main(String[] args) {

        SpringApplication.run(SqsexampleApplication.class, args);

	}

}

package com.example.RabbitMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMQ {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQ.class, args);
    }
}

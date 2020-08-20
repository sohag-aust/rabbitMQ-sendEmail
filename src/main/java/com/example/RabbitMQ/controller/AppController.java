package com.example.RabbitMQ.controller;

import com.example.RabbitMQ.config.EmailConfig;
import com.example.RabbitMQ.message.RabbitMQMessage;
import com.example.RabbitMQ.request.UserCreateRequest;
import com.example.RabbitMQ.service.RabbitMQSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private RabbitMQSender rabbitMQSender;

    public AppController(EmailConfig emailConfig, RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserCreateRequest userCreateRequest) {

        RabbitMQMessage rabbitMQMessage = new RabbitMQMessage();
        rabbitMQMessage.setUserName(userCreateRequest.getUserName());
        rabbitMQMessage.setMailTo(userCreateRequest.getEmail());
        rabbitMQMessage.setMessageOption("simpleEmail");
        rabbitMQSender.sendMessage(rabbitMQMessage);

        return "Congratulations! You have registered successfully...";
    }


    @PostMapping("/sendAttachment")
    public String sendWithAttachment(@RequestBody UserCreateRequest userCreateRequest)  {

        RabbitMQMessage rabbitMQMessage = new RabbitMQMessage();
        rabbitMQMessage.setUserName(userCreateRequest.getUserName());
        rabbitMQMessage.setMailTo(userCreateRequest.getEmail());
        rabbitMQMessage.setMessageOption("EmailWithAttachment");
        rabbitMQSender.sendMessage(rabbitMQMessage);

        return "Congratulations! You have registered successfully...";
    }
}



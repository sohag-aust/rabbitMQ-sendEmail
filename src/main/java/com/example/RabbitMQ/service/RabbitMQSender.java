package com.example.RabbitMQ.service;

import com.example.RabbitMQ.config.RabbitMQConfig;
import com.example.RabbitMQ.message.RabbitMQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(RabbitMQMessage rabbitMQMessage) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EMAIL_PROCESSING_QUEUE, rabbitMQMessage);
        log.info("Message has been sent !!!");
    }
}

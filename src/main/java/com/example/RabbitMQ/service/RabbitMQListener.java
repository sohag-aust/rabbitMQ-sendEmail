package com.example.RabbitMQ.service;

import com.example.RabbitMQ.config.RabbitMQConfig;
import com.example.RabbitMQ.message.RabbitMQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class RabbitMQListener {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

    private MailService mailService;

    public RabbitMQListener(MailService mailService) {
        this.mailService = mailService;
    }

    @RabbitListener(queues = RabbitMQConfig.EMAIL_PROCESSING_QUEUE)
    public void consumeDefaultMessage(RabbitMQMessage message) throws MessagingException {
        log.info("Received message, tip is: {}", message.getUserName());
        log.info("Message option is: " + message.getMessageOption());

        if(message.getMessageOption().equals("EmailWithAttachment")) {
            mailService.sendEmailWithAttachment(message);
        }else {
            mailService.sendEmail(message);
        }
    }
}

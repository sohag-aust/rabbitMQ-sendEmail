package com.example.RabbitMQ.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMQMessage implements Serializable {

    private String userName;
    private String mailTo;
    private String mailFrom = "abc@gmail.com";
    private String subject = "Testing Mail API";
    private String text = "Hurray ! Message has been sent through RabbitMQ !!!";
    private String messageOption;
}

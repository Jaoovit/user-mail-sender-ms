package com.oliveira.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener
    public void listenEmailQueue(@Payload String emailMessage) {
        System.out.println("Consuming email message: " + emailMessage);
    }

}

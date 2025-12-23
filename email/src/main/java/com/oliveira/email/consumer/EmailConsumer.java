package com.oliveira.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${RABBIT_QUEUE:user.created.queue}")
    public void listenEmailQueue(@Payload String emailMessage) {
        System.out.println("Consuming email message: " + emailMessage);
    }

}

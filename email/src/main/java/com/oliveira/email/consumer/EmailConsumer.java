package com.oliveira.email.consumer;

import com.oliveira.email.dto.UserInfoDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "email-queue")
    public void listenEmailQueue(@Payload String email) {
        System.out.println(email);
    }

}

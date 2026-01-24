package com.oliveira.email.consumer;

import com.oliveira.email.configuration.RabbitMq;
import com.oliveira.email.dto.UserInfoDTO;
import com.oliveira.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitMq.QUEUE_NAME)
    public void listenEmailQueue(@Payload UserInfoDTO userInfoDTO) {
        try {
            emailService.sendEmail(userInfoDTO);
        } catch (Exception e) {
            System.err.println("Failed to process message: " + e.getMessage());
        }
    }

}

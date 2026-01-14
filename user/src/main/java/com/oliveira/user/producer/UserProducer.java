package com.oliveira.user.producer;

import com.oliveira.user.configuration.RabbitMq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    private RabbitTemplate rabbitTemplate;

    public void sendUserInformation(String userInformation) {
        rabbitTemplate.convertAndSend(
                RabbitMq.EXCHANGE_NAME,
                "user-info",
                userInformation
        );
    }

}

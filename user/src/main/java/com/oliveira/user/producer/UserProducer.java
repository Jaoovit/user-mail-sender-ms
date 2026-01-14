package com.oliveira.user.producer;

import com.oliveira.user.configuration.RabbitMq;
import com.oliveira.user.dto.UserInfoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendUserInformation(UserInfoDTO userInformation) {
        rabbitTemplate.convertAndSend(
                RabbitMq.EXCHANGE_NAME,
                "user-info",
                userInformation
        );
    }

}

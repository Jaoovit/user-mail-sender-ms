package com.oliveira.email.consumer;

import com.oliveira.email.configuration.RabbitMq;
import com.oliveira.email.dto.UserInfoDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = RabbitMq.QUEUE_NAME)
    public void listenEmailQueue(@Payload UserInfoDTO userInfoDTO) {
        System.out.println(userInfoDTO.username());
        System.out.println(userInfoDTO.email());
        System.out.println(userInfoDTO.password());
    }

}

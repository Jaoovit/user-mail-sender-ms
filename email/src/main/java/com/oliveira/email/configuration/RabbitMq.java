package com.oliveira.email.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMq {

    private final String QUEUE_NAME = "email-queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

}

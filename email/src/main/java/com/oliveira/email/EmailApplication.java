package com.oliveira.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.mail.autoconfigure.MailSenderAutoConfiguration;

@SpringBootApplication(exclude = { MailSenderAutoConfiguration.class })
public class EmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}
}
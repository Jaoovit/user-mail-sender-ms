package com.oliveira.email.service;

import com.oliveira.email.dto.UserInfoDTO;
import com.oliveira.email.model.Email;
import com.oliveira.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${SPRING_MAIL_HOST}")
    private String fromEmail;

    @Autowired
    private EmailRepository emailRepository;

    private Email constructEmail(UserInfoDTO userInfoDTO) {
        Email email = new Email();

        email.setUserId(userInfoDTO.userId());
        email.setTo(userInfoDTO.email());
        email.setFrom(fromEmail);

        String emailSubject = "Welcome " + userInfoDTO.username() + "!";

        String emailBody = "Welcome to our service! Your temporary credentials is.\n\n" +
                "Username: " + userInfoDTO.username() + "\n" +
                "Password: " + userInfoDTO.password() + "\n\n";


        email.setSubject(emailSubject);
        email.setBody(emailBody);

        emailRepository.save(email);

        return email;
    }

}

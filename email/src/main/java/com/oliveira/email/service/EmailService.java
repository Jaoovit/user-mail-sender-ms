package com.oliveira.email.service;

import com.oliveira.email.dto.RequestEmailDTO;
import com.oliveira.email.model.Email;
import com.oliveira.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Email sendEmail(RequestEmailDTO data) {
        Email email = new Email();
        email.setFrom("example@gmail.com");
        email.setTo("example@gmail.com");
        email.setSubject("Subject");
        email.setBody("Email body");
        emailRepository.save(email);
        return email;
    }

}

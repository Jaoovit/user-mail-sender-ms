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
        email.setFrom(data.from());
        email.setTo(data.to());
        email.setSubject(data.subject());
        email.setBody(data.body());
        email.setUserId(data.userId());
        emailRepository.save(email);
        return email;
    }

}

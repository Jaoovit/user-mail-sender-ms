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
        email.setId(data.id());
        email.setSubject(data.subject());
        email.setBody(data.body());
        emailRepository.save(email);
        return email;
    }

}

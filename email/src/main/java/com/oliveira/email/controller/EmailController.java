package com.oliveira.email.controller;

import com.oliveira.email.dto.RequestEmailDTO;
import com.oliveira.email.dto.ResponseEmailDTO;
import com.oliveira.email.model.Email;
import com.oliveira.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<ResponseEmailDTO> sendEmail(@Valid @RequestBody RequestEmailDTO data) {
        Email email = emailService.sendEmail(data);
        ResponseEmailDTO emailDTO = new ResponseEmailDTO(
                email.getTo(),
                email.getFrom(),
                email.getSubject(),
                email.getBody()
        );
        return ResponseEntity.ok(emailDTO);
    }
}

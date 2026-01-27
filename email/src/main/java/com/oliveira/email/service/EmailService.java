package com.oliveira.email.service;

import com.oliveira.email.dto.UserInfoDTO;
import com.oliveira.email.model.Email;
import com.oliveira.email.repository.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${SPRING_MAIL_HOST}")
    private String fromEmail;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(UserInfoDTO userInfoDTO) throws MessagingException {
        Email email = constructEmail(userInfoDTO);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

        helper.setTo(email.getTo());
        helper.setFrom(email.getFrom());
        helper.setText(email.getBody(), true);
        helper.setSubject(email.getSubject());
        javaMailSender.send(message);
    }

    private Email constructEmail(UserInfoDTO userInfoDTO) {
        Email email = getEmail(userInfoDTO);

        emailRepository.save(email);
        return email;
    }

    private @NonNull Email getEmail(UserInfoDTO userInfoDTO) {
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
        return email;
    }

}

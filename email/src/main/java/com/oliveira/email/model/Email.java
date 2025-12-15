package com.oliveira.email.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity()
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Email is required")
    @jakarta.validation.constraints.Email(message = "Email should be valid")
    private String to;

    @NotBlank(message = "Email is required")
    @jakarta.validation.constraints.Email(message = "Email should be valid")
    private String from;

    @Size(max = 30, message = "Subject can't exceed 30 characters")
    private String subject;

    @Size(max = 200, message = "Email body can't exceed 200 characters")
    private String body;
}

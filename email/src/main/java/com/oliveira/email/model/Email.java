package com.oliveira.email.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity()
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "send_to", nullable = false)
    private String to;

    @Column(name = "send_by", nullable = false)
    private String from;

    @Column(length = 250, nullable = false)
    private String subject;

    @Column(length = 350, nullable = false)
    private String body;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

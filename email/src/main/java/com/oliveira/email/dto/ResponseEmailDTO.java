package com.oliveira.email.dto;

public record ResponseEmailDTO(String to, String from, String subject, String body) {
}

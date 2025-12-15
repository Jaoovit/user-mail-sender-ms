package com.oliveira.email.dto;

public record RequestEmailDTO(String to, String from, String subject, String body) {
}

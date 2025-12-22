package com.oliveira.email.dto;

import java.util.UUID;

public record RequestEmailDTO(String to, String from, String subject, String body, UUID userId) {
}

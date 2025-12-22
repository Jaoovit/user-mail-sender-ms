package com.oliveira.email.dto;

import java.util.UUID;

public record RequestEmailDTO(UUID id, String subject, String body) {
}

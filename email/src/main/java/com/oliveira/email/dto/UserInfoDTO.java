package com.oliveira.email.dto;

import java.util.UUID;

public record UserInfoDTO(UUID userId, String username, String email, String password) {
}

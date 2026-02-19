package com.oliveira.user.repository;

import com.oliveira.user.dto.RequestUserDTO;
import com.oliveira.user.model.User;
import jakarta.persistence.EntityManager;
import org.apache.commons.text.RandomStringGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Get User successfully")
    void findUserByUsernameSuccess() {
        String username = "QAUser-1";
        RequestUserDTO requestUserDTO = new RequestUserDTO(username, "QAUser-1@email.com");
        User user = createUser(requestUserDTO);
        User result = userRepository.findUserByUsername(user.getUsername());
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Get User with non existing username")
    void findUserByUsernameFail() {
        String username = "NonExistingUser";
        User result = userRepository.findUserByUsername(username);
            assertThat(result).isNull();
    }

    private User createUser(RequestUserDTO data) {
        User user = new User();
        user.setUsername(data.username());
        user.setEmail(data.email());

        String randomPassword = generateRandomPassword();
        user.setPassword(randomPassword);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        entityManager.persist(user);
        return user;
    }

    private String generateRandomPassword() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange(33, 126)
                .usingRandom(new SecureRandom()::nextInt)
                .build();

        return generator.generate(16);
    }
}
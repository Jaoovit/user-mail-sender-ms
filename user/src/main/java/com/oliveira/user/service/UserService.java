package com.oliveira.user.service;

import com.oliveira.user.dto.RequestUserDTO;
import com.oliveira.user.model.User;
import com.oliveira.user.repository.UserRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(RequestUserDTO data) {
        User user = new User();
        user.setUsername(data.username());
        user.setPassword(generateRandomPassword());
        return user;
    }

    public String generateRandomPassword() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange(33, 126)
                .usingRandom(new SecureRandom()::nextInt)
                .build();

        return generator.generate(16);
    }
}

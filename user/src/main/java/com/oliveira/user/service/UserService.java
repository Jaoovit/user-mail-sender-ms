package com.oliveira.user.service;

import com.oliveira.user.dto.RequestUserDTO;
import com.oliveira.user.dto.UserInfoDTO;
import com.oliveira.user.model.User;
import com.oliveira.user.producer.UserProducer;
import com.oliveira.user.repository.UserRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    public User createUser(RequestUserDTO data) {

        checkIfUserExist(data.username());

        User user = new User();
        user.setUsername(data.username());
        user.setEmail(data.email());

        String randomPassword = generateRandomPassword();
        user.setPassword(randomPassword);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        UserInfoDTO userInfoDTO = new UserInfoDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                randomPassword
        );

        userProducer.sendUserInformation(userInfoDTO);
        return user;
    }

    private String generateRandomPassword() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange(33, 126)
                .usingRandom(new SecureRandom()::nextInt)
                .build();

        return generator.generate(16);
    }

    private void checkIfUserExist(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) throw new RuntimeException("User already exist");
    }
}

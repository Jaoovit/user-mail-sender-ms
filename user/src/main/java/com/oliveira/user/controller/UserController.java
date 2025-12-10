package com.oliveira.user.controller;

import com.oliveira.user.dto.RequestUserDTO;
import com.oliveira.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void>createUser(@RequestBody RequestUserDTO data) {
        userService.createUser(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

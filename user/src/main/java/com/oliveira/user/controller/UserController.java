package com.oliveira.user.controller;

import com.oliveira.user.dto.RequestUserDTO;
import com.oliveira.user.dto.ResponseUserDTO;
import com.oliveira.user.model.User;
import com.oliveira.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<ResponseUserDTO>createUser(@RequestBody RequestUserDTO data) {
        User user = userService.createUser(data);
        ResponseUserDTO userDTO = new ResponseUserDTO(user.getUsername(), user.getEmail());
        return ResponseEntity.ok(userDTO);
    }
}

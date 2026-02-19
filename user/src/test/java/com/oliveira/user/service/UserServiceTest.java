package com.oliveira.user.service;

import com.oliveira.user.dto.RequestUserDTO;
import com.oliveira.user.model.User;
import com.oliveira.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    @DisplayName("Create User successfully")
    void createUserSuccessfully() {
        RequestUserDTO dto = new RequestUserDTO("QAUser-2", "QAUser-2@email.com");

        when(userRepository.findUserByUsername("QAUser-2"))
                .thenReturn(null);

        User saved = new User();
        when(userRepository.save(any(User.class)))
                .thenReturn(saved);

        User result = userService.createUser(dto);

        assertThat(result).isNotNull();
        assertThat(result.getUsername()).isEqualTo("QAUser-2");

        verify(userRepository).save(any(User.class));
    }

    @Test
    @DisplayName("Fail to create user with existing username")
    void failCreateUserWithExistingUsername() {
        RequestUserDTO dto = new RequestUserDTO("QAUser-3", "QAUser-3@email.com");

        when(userRepository.findUserByUsername("QAUser-3"))
                .thenReturn(new User());

        assertThatThrownBy(() -> userService.createUser(dto))
                .isInstanceOf(IllegalArgumentException.class);

        verify(userRepository, never()).save(any());
    }
}
package tech.math.agregadorinvestimentos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.time.Instant;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tech.math.agregadorinvestimentos.controller.CreateUserDto;
import tech.math.agregadorinvestimentos.entity.User;
import tech.math.agregadorinvestimentos.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Nested
    class CreateUser {
        @Test
        @DisplayName("Deve criar um novo usuário com sucesso")
        void shouldCreateUserWithSuccess() {
            // Arrange
            var user = new User (
                UUID.randomUUID(),
                "username",
                "email@email.com",
                "password",
                Instant.now(),
                null
            );
            doReturn(user).when(userRepository).save(userArgumentCaptor.capture());
            var input = new CreateUserDto(
                "username",
                "email@email.com",
                "password"
            );

            // Act
            var output = userService.createUser(input);
            // Assert
            assertNotNull(output);
            var capturedUser = userArgumentCaptor.getValue();
            assertEquals(input.username(), capturedUser.getUsername());
            assertEquals(input.email(), capturedUser.getEmail());
            assertEquals(input.password(), capturedUser.getPassword());
        }

        @Test
        @DisplayName("Should throw exception when error occurs")
        void shouldThrowExceptionWhenErrorOccurs() {
            doThrow(new RuntimeException()).when(userRepository).save(any());
            var input = new CreateUserDto(
                "username",
                "email@email.com",
                "password"
            );

            // Act & Assert
            assertThrows(RuntimeException.class, () -> {
                userService.createUser(input);
            });
        }
    }
}

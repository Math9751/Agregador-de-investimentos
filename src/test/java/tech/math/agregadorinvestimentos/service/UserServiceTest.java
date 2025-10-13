package tech.math.agregadorinvestimentos.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tech.math.agregadorinvestimentos.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testCreateUser() {

    }

    @Test
    void testDeleteUser() {

    }

    @Test
    void testGetAllUsers() {

    }

    @Test
    void testGetUserById() {

    }

    @Test
    void testUpdateUserById() {

    }
}

package tech.math.agregadorinvestimentos.service;

import java.util.Optional;
import java.util.UUID;

//import java.time.Instant;
//import java.util.UUID;

import org.springframework.stereotype.Service;

import tech.math.agregadorinvestimentos.controller.CreateUserDto;
import tech.math.agregadorinvestimentos.entity.User;
import tech.math.agregadorinvestimentos.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserDto createUserDto) {
        var entity = new User(
                null,
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                null,
                null);
        return userRepository.save(entity);
    }
    
    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));
    }
}

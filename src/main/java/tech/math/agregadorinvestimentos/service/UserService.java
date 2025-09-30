package tech.math.agregadorinvestimentos.service;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

//import java.time.Instant;
//import java.util.UUID;

import org.springframework.stereotype.Service;

import tech.math.agregadorinvestimentos.controller.CreateUserDto;
import tech.math.agregadorinvestimentos.controller.UpdateUserDto;
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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDto updateUserDto) {
        var id = UUID.fromString(userId);
        var userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            var user = userEntity.get();
            if (updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }
            if (updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }
            userRepository.save(user);
    }  
    }

    public void deleteUser(String userId) {
        var id = UUID.fromString(userId);
        var userExists = userRepository.existsById(id);
        if (userExists) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist.");
        }
    }

     
}

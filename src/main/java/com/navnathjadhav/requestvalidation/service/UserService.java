package com.navnathjadhav.requestvalidation.service;

import com.navnathjadhav.requestvalidation.dto.UserRequest;
import com.navnathjadhav.requestvalidation.entity.User;
import com.navnathjadhav.requestvalidation.exception.SaveFailedException;
import com.navnathjadhav.requestvalidation.exception.UserNotFoundException;
import com.navnathjadhav.requestvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserById(long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User save(UserRequest userRequest) throws SaveFailedException {
        User user = User.build(null, userRequest.name(), userRequest.age(), userRequest.email(), userRequest.password(), userRequest.mobileNo());
        User savedUser = userRepository.save(user);
        if (Objects.isNull(savedUser)) throw new SaveFailedException("Failed to save user, Unknown error");
        return savedUser;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}

package com.example.boysfromgopcity.service;


import com.example.boysfromgopcity.entity.User;
import com.example.boysfromgopcity.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {

        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public void updateTransfer(Long id, User user) {

        User exitingUser = userRepository.findById(id).orElseThrow(RuntimeException::new);

        exitingUser.setName(user.getName());
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}

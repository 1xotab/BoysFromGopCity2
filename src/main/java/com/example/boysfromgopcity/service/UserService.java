package com.example.boysfromgopcity.service;

import com.example.boysfromgopcity.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    void updateTransfer(Long id, User user);

    void deleteUserById(Long id);
}

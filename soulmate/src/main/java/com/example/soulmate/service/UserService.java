package com.example.soulmate.service;

import com.example.soulmate.model.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();

    User findByIdUser(Long id);

    void save(User user);



    void deleteById(Long id);

    User updateUserById(Long id, User user);

    User updateUser(User user);

    Optional<User> findById(Long id);
}

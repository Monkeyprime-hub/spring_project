package com.example.soulmate.service;

import com.example.soulmate.model.User;
import com.example.soulmate.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    UserRepository userRepository;


    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByIdUser(Long id) {
        LOGGER.info("Ishem usera");
        return userRepository.findByIdUser(id);
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUserById(Long id, User user) {
        User byIdUser = userRepository.findByIdUser(id);
        byIdUser.setFirstName(user.getFirstName());
        byIdUser.setLastName(user.getLastName());
        byIdUser.setPatronymic(user.getPatronymic());
        byIdUser.setAge(user.getAge());

        return byIdUser;
    }

    @Override
    public User updateUser(User user) {
        return new User();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}

package com.example.soulmate.repo;

import com.example.soulmate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();

    User findByIdUser(Long id);

    Optional<User> findById(Long id);

    Optional<User> findByFirstNameAndAge(String name, int age);
}

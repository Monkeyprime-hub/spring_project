package com.example.soulmate.controller;


import com.example.soulmate.model.User;
import com.example.soulmate.repo.UserRepository;
import com.example.soulmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class RestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;



    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<Book> getOne(@PathVariable("id")Long id ) {
//        Optional<Book> book = Optional.ofNullable(bookDao.getOne(id));
//         if (book.isPresent()) {
//            return new ResponseEntity<>(book.get(), HttpStatus.OK);
//        }
//                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable("id") Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    @PostMapping(consumes = "application/json")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        try {
            userService.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @PutMapping("/putt/{id}")
    public User putUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/put/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User user) {
//        Book book1 = new Book();
//        book1.setIdBook(5L);
//        book1.setBookAuthor("Стивен Кинг");
//        book1.setBookTitle("Оно");
        System.out.println("Итерация 1" + user.toString());

        User byIdUser = userService.findByIdUser(id);
        System.out.println("Итерация 2" + byIdUser.toString());

        byIdUser.setIdUser(user.getIdUser());
        byIdUser.setFirstName(user.getFirstName());
        byIdUser.setLastName(user.getLastName());
        byIdUser.setPatronymic(user.getPatronymic());
        byIdUser.setAge(user.getAge());
        System.out.println("Итерация 3" + byIdUser);
        return userRepository.save(byIdUser);
//        return byIdUser;
    }

    @PatchMapping(value = "/patch/{id}", consumes = "application/json")
    public User patchBook(@PathVariable("id") Long id, @RequestBody User userPath) {
        User bookRefresh = userService.findById(id).get();
        if (userPath.getFirstName() != null) {
            bookRefresh.setFirstName(userPath.getFirstName());
        }
        if (userPath.getLastName() != null) {
            bookRefresh.setLastName(userPath.getLastName());
        }
        if (userPath.getPatronymic() != null) {
            bookRefresh.setPatronymic(userPath.getPatronymic());
        }
        if (userPath.getAge() != 0) {
            bookRefresh.setAge(userPath.getAge());
        }
        return userRepository.save(bookRefresh);
    }


}


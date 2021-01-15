package com.example.soulmate.controller;

import com.example.soulmate.model.User;
import com.example.soulmate.repo.UserRepository;
import com.example.soulmate.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("newUser", new User());
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/show")
    public String showById(@PathVariable("id") Long id, Model model) {
        if (userService.findById(id).isPresent()) {
            model.addAttribute("user", userService.findById(id).get());
//            System.out.println(model);
            return "show";
        }
        model.addAttribute("user", new User());
        return "show";
    }

    @GetMapping("/{id}/delete")
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public String deleteById(@PathVariable("id") Long id) {
        try {
            userService.deleteById(id);
//            doExpensiveWork();
            return "redirect:/users";
        } catch (EmptyResultDataAccessException e) {
            log.info(e.getMessage());
        }
        return "redirect:/users";
    }

//    @DeleteMapping
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
//public void deleteBookById(@PathVariable("id") Long id) {
//        try {
//            userService.deleteById(id);
//            doExpensiveWork();
//        }catch (EmptyResultDataAccessException | InterruptedException e) {
//            log.info(e.getMessage());
//        }
//    }

    private void doExpensiveWork() throws InterruptedException {
        Thread.sleep(5000);
        throw new RuntimeException();
    }


    @GetMapping("/{id}/edit")
    public String editFormById(@PathVariable("id") Long id, Model model) {
        if (userService.findById(id).isPresent()) {
            model.addAttribute("user", userService.findById(id).get());
            System.out.println(model);
            return "edit";
        }
        model.addAttribute("user", new User());
        return "edit";
    }

    @PostMapping("/{id}")
    public String editById(@PathVariable("id") Long id, User user) {
        System.out.println(user);
        System.out.println(user.getIdUser());
        userService.save(user);
        return "redirect:/users";
    }

//    @PostMapping("/put/{id}")
//    public User editById(@PathVariable("id") Long id, @RequestBody User user) {
//        System.out.println("1" + user.toString());
//
//        User userById = userService.findByIdUser(id);
//        System.out.println("2" + userById.toString());
//
//        userById.setIdUser(user.getIdUser());
//        userById.setFirstName(user.getFirstName());
//        userById.setLastName(user.getLastName());
//        userById.setAge(user.getAge());
//        System.out.println("3" + userById.toString());
//
//        return userById;
//
//    }

}

package com.example.soulmate.controller;

import com.example.soulmate.model.User;
import com.example.soulmate.repo.UserRepository;
import com.example.soulmate.service.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestController.class)
class RestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    UserRepository userRepository;


    @Test
    void getAllUsers() throws Exception {
        when(userService.findAll()).thenReturn(Arrays.asList(
                new User(1L, "V", "V", "V", 13),
                new User(2L, "N", "N", "N", 12)
        ));

        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[*].idUser", containsInAnyOrder(1, 2)))
                .andExpect(jsonPath("$[*].firstName", containsInAnyOrder("V", "N")));
    }

    @Test
    void findByIdUser() throws Exception {
        when(userService.findById(anyLong())).thenReturn(Optional.of(
                new User(1L, "V", "V", "V", 13))
        );

        mockMvc.perform(get("/api/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idUser", equalTo(1)))
                .andExpect(jsonPath("$.age", equalTo(13)));
    }

    @Test
    void saveUser() {
    }

    @Test
    void deleteUserById() {

    }

    @Test
    void putUser() {
    }

//    @Test
//    void updateUserById() throws Exception {
//        User user = new User(2L, "V", "V", "V", 13);
//        when(userService.updateUserById(anyLong(), user)).thenReturn(
//                new User(1L, "V", "V", "V", 13)
//        );
//        mockMvc.perform(get("/put/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.idUser", equalTo(1)))
//                .andExpect(jsonPath("$.age", equalTo(13)));
//    }

    @Test
    void patchBook() {
    }
}
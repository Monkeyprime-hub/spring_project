package com.example.soulmate.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "u_first_name")
    private String firstName;
    @Column(name = "u_last_name")
    private String lastName;
    @Column(name = "u_patronymic")
    private String patronymic;
    @Column(name = "u_age")
    private int age;

    public User() {
    }


    public User(Long idUser, String firstName, String lastName, String patronymic, int age) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.age = age;
    }
}

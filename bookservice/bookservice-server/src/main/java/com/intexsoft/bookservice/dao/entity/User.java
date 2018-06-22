package com.intexsoft.bookservice.dao.entity;

import com.intexsoft.bookservice.dao.entity.enums.UserMale;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {
    @Enumerated(EnumType.STRING)
    @Column(name = "male")
    UserMale userMale;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "login", length = 45)
    private String username;
    @Column(name = "password", length = 100)
    private String password;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "surname", length = 45)
    private String surname;
    @Column(name = "role", length = 45)
    private String role;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserMale getUserMale() {
        return userMale;
    }

    public void setUserMale(UserMale userMale) {
        this.userMale = userMale;
    }
}

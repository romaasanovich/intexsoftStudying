package com.intexsoft.bookservice.web.dto.entity;

public class UserDto {
    private String userMale;
    private String email;
    private String username;
    private String password;
    private String name;
    private String surname;

    public String getUserMale() {
        return userMale;
    }

    public void setUserMale(String userMale) {
        this.userMale = userMale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

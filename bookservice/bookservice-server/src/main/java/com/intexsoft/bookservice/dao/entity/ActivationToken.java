package com.intexsoft.bookservice.dao.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activationToken")
public class ActivationToken {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "token")
    private String token;
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    @Column(name = "registrationTime")
    private LocalDateTime registrationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}

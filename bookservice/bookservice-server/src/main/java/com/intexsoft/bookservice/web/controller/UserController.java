package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public void registerUser(@RequestBody User user) {
        userService.addUser(user);
    }


    @GetMapping(path = "/user")
    public User getByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return userService.getByUsername(currentPrincipalName);
    }
}

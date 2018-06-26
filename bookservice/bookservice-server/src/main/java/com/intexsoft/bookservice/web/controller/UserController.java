package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.service.api.UserService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IOException | TemplateException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping(path = "/user/activate")
    public void activateUser(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "token") String token) {
        userService.activate(userId, token);
    }

    @PostMapping(path = "/user/edit")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    @GetMapping(path = "/user")
    public User getByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return userService.getByUsername(currentPrincipalName);
    }

    @PostMapping(path = "/user/password")
    public ResponseEntity changePassword(@RequestParam(name = "oldPassword") String oldPassword, @RequestParam(name = "newPassword") String newPassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.getByUsername(currentPrincipalName);
        if (userService.changePassword(user, oldPassword, newPassword)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

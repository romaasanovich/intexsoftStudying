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
    public boolean activateUser(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "token") String token) {
        return userService.activate(userId, token);
    }

    @PostMapping(path = "/user/edit")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    @PostMapping(path = "/user/delete")
    public ResponseEntity deletedUser(@RequestParam(name = "userId") Integer userId) {
        User user = userService.getById(userId);
        if (user != null) {
            userService.deleteDisabledUser(user);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping(path = "/user/reactivate")
    public ResponseEntity reactivateUser(@RequestParam(name = "userId") Integer userId) {
        try {
            User user = userService.getById(userId);
            userService.sendReactivateMessage(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IOException | TemplateException e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @PostMapping(path = "/user/password/restore/code")
    public Integer sendRestoreCode(@RequestParam(name = "username") String username) {
        User user = userService.getByUsername(username);
        try {
            return userService.sendRestoreCode(user);
        } catch (TemplateException | IOException e) {
            return -1;
        }
    }

    @PostMapping(path = "/user/password/restore/link")
    public ResponseEntity sendRestoreLink(@RequestParam(name = "username") String username) {
        User user = userService.getByUsername(username);
        try {
            userService.sendRestoreLink(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (TemplateException | IOException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/user/password/restore")
    public ResponseEntity restorePassword(@RequestParam(name = "password") String password, @RequestParam(name = "username") String username) {
        User user = userService.getByUsername(username);
        if (userService.restorePass(user, password)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

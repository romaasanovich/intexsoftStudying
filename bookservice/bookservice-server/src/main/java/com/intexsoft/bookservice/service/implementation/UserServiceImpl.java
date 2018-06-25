package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.ActivationToken;
import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.dao.entity.enums.UserRole;
import com.intexsoft.bookservice.dao.repository.UserRepository;
import com.intexsoft.bookservice.service.api.ActivationTokenService;
import com.intexsoft.bookservice.service.api.EmailService;
import com.intexsoft.bookservice.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ActivationTokenService activationTokenService;


    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole(UserRole.ROLE_CUSTOMER);
        user.setActivated(false);
        ActivationToken activationToken = new ActivationToken();
        activationToken.setRegistrationTime(LocalDateTime.now());
        activationToken.setToken(UUID.randomUUID().toString());
        userRepository.save(user);
        activationToken.setUser(userRepository.findByUsername(user.getUsername()));
        activationTokenService.add(activationToken);
        emailService.sendMessage(user,activationToken.getToken());
    }

    @Override
    public void editUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean changePassword(User user, String oldPassword, String newPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(encoder.encode(newPassword));
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean activate(Integer userId, String token) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && !user.getActivated() && activationTokenService.isNotExpired(user)){
            user.setActivated(true);
            activationTokenService.deleteByUserId(userId);
            userRepository.save(user);
            return true;
        }
        else {
            return false;
        }
    }
}

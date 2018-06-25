package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.dao.entity.enums.UserRole;
import com.intexsoft.bookservice.dao.repository.UserRepository;
import com.intexsoft.bookservice.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole(UserRole.ROLE_CUSTOMER);
        userRepository.save(user);
    }
}

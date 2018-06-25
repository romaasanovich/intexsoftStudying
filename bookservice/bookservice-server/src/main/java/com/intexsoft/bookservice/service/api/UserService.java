package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.User;

public interface UserService {
    User getByUsername(String username);

    void addUser(User user);

    void editUser(User user);

    boolean changePassword(User user, String oldPassword, String newPassword);
}

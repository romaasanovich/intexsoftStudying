package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.User;
import freemarker.template.TemplateException;

import java.io.IOException;

public interface UserService {
    User getByUsername(String username);

    User getById(Integer id);

    void addUser(User user) throws IOException, TemplateException;

    void editUser(User user);

    boolean changePassword(User user, String oldPassword, String newPassword);

    boolean restorePass(User user, String password);

    boolean activate(Integer userId, String token);

    void deleteDisabledUser(User user);

    int sendRestoreCode(User user) throws IOException, TemplateException;

    void sendRestoreLink(User user) throws IOException, TemplateException;

    void sendReactivateMessage(User user) throws IOException, TemplateException;
}

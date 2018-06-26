package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.User;
import freemarker.template.TemplateException;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface UserService {
    User getByUsername(String username);

    void addUser(User user) throws IOException, TemplateException;

    void editUser(User user);

    boolean changePassword(User user, String oldPassword, String newPassword);

    @Transactional
    boolean restorePass(User user, String password);

    boolean activate(Integer userId, String token);

    int sendRestoreCode(User user) throws IOException, TemplateException;
}

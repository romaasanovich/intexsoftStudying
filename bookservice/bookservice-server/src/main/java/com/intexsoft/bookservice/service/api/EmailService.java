package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.User;

public interface EmailService {

    void sendMessage(User user);
}

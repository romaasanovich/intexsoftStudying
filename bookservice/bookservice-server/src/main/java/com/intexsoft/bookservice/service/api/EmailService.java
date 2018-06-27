package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.service.implementation.email.EmailWrapper;

public interface EmailService {

    void sendMessage(EmailWrapper emailWrapper);
}

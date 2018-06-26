package com.intexsoft.bookservice.service.api;

public interface EmailService {

    void sendMessage(String toEmail, String subject, String emailMessage);
}

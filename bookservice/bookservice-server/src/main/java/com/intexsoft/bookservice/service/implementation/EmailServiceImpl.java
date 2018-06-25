package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.service.api.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger("log");

    @Value("${email.username}")
    private String username;
    @Value("${email.password}")
    private String password;
    @Value("${email.host}")
    private String host;
    @Value("${email.port}")
    private String port;


    private Properties getMailSessionProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.socketFactory.port", port);
        prop.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", port);
        return prop;
    }

    private Session getSession() {
        return Session.getInstance(getMailSessionProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    @Override
    public void sendMessage(String toEmail) {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(username + "@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Test Subject");
            message.setText("Test message!!!");
            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("Error with sending messageon e-mail:", e);
        }
    }


}

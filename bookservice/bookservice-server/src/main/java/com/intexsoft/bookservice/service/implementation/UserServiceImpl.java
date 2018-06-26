package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.config.AppConfig;
import com.intexsoft.bookservice.dao.entity.ActivationToken;
import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.dao.entity.enums.UserRole;
import com.intexsoft.bookservice.dao.repository.UserRepository;
import com.intexsoft.bookservice.service.api.ActivationTokenService;
import com.intexsoft.bookservice.service.api.EmailService;
import com.intexsoft.bookservice.service.api.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger("log");
    private static final String URL = "http://localhost:8080/bookservice/api/user/activate?";

    @Autowired
    private AppConfig appConfig;

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
    @Transactional
    public void addUser(User user) throws IOException, TemplateException {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole(UserRole.ROLE_CUSTOMER);
        user.setActivated(false);
        ActivationToken activationToken = new ActivationToken();
        activationToken.setRegistrationTime(LocalDateTime.now());
        activationToken.setToken(UUID.randomUUID().toString());
        userRepository.save(user);
        activationToken.setUser(userRepository.findByUsername(user.getUsername()));
        activationTokenService.add(activationToken);
        sendRegistrationMessage(user, activationToken.getToken());
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
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
    @Transactional
    public boolean activate(Integer userId, String token) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && !user.getActivated() && activationTokenService.isNotExpired(user)) {
            user.setActivated(true);
            activationTokenService.deleteByUserId(userId);
            userRepository.save(user);
            return true;
        } else if (user != null && !activationTokenService.isNotExpired(user)) {
            activationTokenService.deleteByUserId(userId);
            userRepository.delete(user);
            return false;
        } else {
            return false;
        }
    }

    private void sendRegistrationMessage(User user, String token) throws IOException, TemplateException {
        Template template = appConfig.freemarkerConfig().getConfiguration().getTemplate("registration.ftl");
        Map<String, Object> root = new HashMap<>();
        root.put("recipient", user);
        root.put("link", generateLink(user, token));
        String subject = "Registration on Book Service!!!";
        String emailMessage = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
        emailService.sendMessage(user.getEmail(), subject, emailMessage);
    }

    private String generateLink(User user, String token) {
        String url = URL + "userId=" + user.getId() + "&token=" + token;
        return MessageFormat.format("<a href=\"{0}\">{0}<a/>", url);
    }
}

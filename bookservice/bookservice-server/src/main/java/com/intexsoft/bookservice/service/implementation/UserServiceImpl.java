package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.config.AppConfig;
import com.intexsoft.bookservice.dao.entity.ActivationToken;
import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.dao.entity.enums.TemplateType;
import com.intexsoft.bookservice.dao.entity.enums.UserRole;
import com.intexsoft.bookservice.dao.repository.UserRepository;
import com.intexsoft.bookservice.service.api.ActivationTokenService;
import com.intexsoft.bookservice.service.api.EmailService;
import com.intexsoft.bookservice.service.api.EmailTemplateService;
import com.intexsoft.bookservice.service.api.UserService;
import com.intexsoft.bookservice.service.implementation.email.EmailWrapper;
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
import java.io.StringReader;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
    private EmailTemplateService emailTemplateService;

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
    public boolean restorePass(User user, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (user != null && !password.isEmpty()) {
            user.setPassword(encoder.encode(password));
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

    @Override
    public int sendRestoreCode(User user) throws IOException, TemplateException {
        String templateCode = emailTemplateService.getByTemplateType(TemplateType.RESTORE_PASSWORD).getFtlCode();
        Template template = new Template("restorePass", new StringReader(templateCode), appConfig.freemarkerConfig().getConfiguration());
        Map<String, Object> root = new HashMap<>();
        root.put("recipient", user);
        int code = new Random().nextInt(90000) + 10000;
        root.put("code", code);
        String emailMessage = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
        EmailWrapper emailWrapper = new EmailWrapper();
        emailWrapper.setToEmail(user.getEmail());
        emailWrapper.setSubject("Restore Password!!!");
        emailWrapper.setEmailBody(emailMessage);
        emailService.sendMessage(emailWrapper);
        return code;
    }

    private void sendRegistrationMessage(User user, String token) throws IOException, TemplateException {
        String templateCode = emailTemplateService.getByTemplateType(TemplateType.REGISTRATION).getFtlCode();
        Template template = new Template("registration", new StringReader(templateCode), appConfig.freemarkerConfig().getConfiguration());
        Map<String, Object> root = new HashMap<>();
        root.put("recipient", user);
        root.put("link", generateLink(user, token));
        String emailMessage = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
        EmailWrapper emailWrapper = new EmailWrapper();
        emailWrapper.setToEmail(user.getEmail());
        emailWrapper.setSubject("Registration on Book Service!!!");
        emailWrapper.setEmailBody(emailMessage);
        emailService.sendMessage(emailWrapper);
    }

    private String generateLink(User user, String token) {
        String url = URL + "userId=" + user.getId() + "&token=" + token;
        return MessageFormat.format("<a href=\"{0}\">{0}<a/>", url);
    }
}

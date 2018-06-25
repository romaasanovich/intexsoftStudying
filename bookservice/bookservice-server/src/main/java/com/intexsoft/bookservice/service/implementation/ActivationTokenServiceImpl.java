package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.ActivationToken;
import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.dao.repository.ActivationTokenRepository;
import com.intexsoft.bookservice.service.api.ActivationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActivationTokenServiceImpl implements ActivationTokenService {

    @Autowired
    private ActivationTokenRepository activationTokenRepository;

    @Override
    public boolean isNotExpired(User user) {
        ActivationToken activationToken = activationTokenRepository.getByUserId(user.getId());
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(activationToken.getRegistrationTime().plusHours(24))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ActivationToken getByUserId(Integer userId) {
        return activationTokenRepository.getByUserId(userId);
    }

    @Override
    public void deleteByUserId(Integer userId) {
        activationTokenRepository.delete(getByUserId(userId));
    }

    @Override
    public void add(ActivationToken activationToken) {
        activationTokenRepository.save(activationToken);
    }
}

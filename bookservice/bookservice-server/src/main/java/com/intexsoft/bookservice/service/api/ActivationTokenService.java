package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.ActivationToken;
import com.intexsoft.bookservice.dao.entity.User;

public interface ActivationTokenService {

    boolean isNotExpired(User user);

    ActivationToken getByUserId(Integer userId);

    void deleteByUserId(Integer userId);

    void add(ActivationToken activationToken);
}

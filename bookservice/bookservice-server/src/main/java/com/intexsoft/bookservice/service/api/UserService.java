package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.User;

public interface UserService {
    User getUserDyUsernameFromDb(String username);
}

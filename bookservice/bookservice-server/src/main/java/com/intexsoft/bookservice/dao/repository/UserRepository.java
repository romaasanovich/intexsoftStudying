package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}

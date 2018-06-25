package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.ActivationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActivationTokenRepository extends JpaRepository<ActivationToken, Integer> {

    @Query
    ActivationToken getByUserId(Integer userId);

}

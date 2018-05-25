package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    @Query(value = "SELECT * FROM publisher where publisher.UUID = ?1", nativeQuery = true)
    Publisher findByUUID(String UUID);

}

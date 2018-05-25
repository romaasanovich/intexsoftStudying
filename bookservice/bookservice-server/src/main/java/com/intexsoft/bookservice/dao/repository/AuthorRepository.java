package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "SELECT * FROM author where author.UUID = ?1", nativeQuery = true)
    Author findByUUID(String UUID);

}

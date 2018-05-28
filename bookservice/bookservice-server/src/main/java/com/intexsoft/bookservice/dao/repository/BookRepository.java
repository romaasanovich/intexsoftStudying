package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM book where book.UUID = ?1", nativeQuery = true)
    Book findUUID(String UUID);

}

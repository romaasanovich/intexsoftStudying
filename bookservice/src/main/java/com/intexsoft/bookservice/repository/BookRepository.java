package com.intexsoft.bookservice.repository;

import com.intexsoft.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM book where book.UUID = ?1", nativeQuery = true)
    Book findUUID(String UUID);

}

package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM image where bookId = ?1", nativeQuery = true)
    List<String> getImagesPath(String bookId);
}

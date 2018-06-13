package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.BookImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<BookImage, Integer> {

    @Query(value = "SELECT * FROM bookImage where bookId = ?1", nativeQuery = true)
    List<BookImage> getImagesPath(String bookId);

}

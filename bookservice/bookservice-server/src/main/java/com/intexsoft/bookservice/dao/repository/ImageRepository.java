package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.BookImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<BookImage, Integer> {

    @Query(value = "SELECT * FROM bookImage where bookId = ?1", nativeQuery = true)
    List<BookImage> getBookImages(Integer bookId);

    @Query(value = "SELECT * FROM bookImage WHERE imageName =?1 and bookId=?2", nativeQuery = true)
    BookImage getBookImageByImageName(Integer bookId, String imageName);

    @Query(value = "SELECT * FROM bookImage WHERE bookId=?1 AND imageType='COVER'", nativeQuery = true)
    BookImage getBookCover(Integer bookId);

    @Query(value = "SELECT * FROM bookImage WHERE bookId=?1 AND imageType='PAGE'", nativeQuery = true)
    List<BookImage> getBookPages(Integer bookId);


}


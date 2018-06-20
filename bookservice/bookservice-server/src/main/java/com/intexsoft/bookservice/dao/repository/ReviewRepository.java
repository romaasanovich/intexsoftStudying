package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT * FROM review where review.bookId = ?1", nativeQuery = true)
    Page<Review> findBookReviews(Integer id, Pageable pageable);

    @Query(value = "SELECT * FROM review where review.bookId = ?1", nativeQuery = true)
    Page<Review> findUserReviews(Integer id, Pageable pageable);

    @Query(value = "SELECT * FROM review where review.bookId = ?1", nativeQuery = true)
    List<Review> findAllBookReviews(Integer id);

}

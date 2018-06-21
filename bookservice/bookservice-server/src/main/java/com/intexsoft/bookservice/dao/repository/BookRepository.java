package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.repository.customrepositories.BookRepositoryCriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryCriteriaBuilder, JpaSpecificationExecutor<Book>, QuerydslPredicateExecutor<Book> {

    @Query(value = "SELECT * FROM book where book.UUID = ?1", nativeQuery = true)
    Book findUUID(String UUID);

}

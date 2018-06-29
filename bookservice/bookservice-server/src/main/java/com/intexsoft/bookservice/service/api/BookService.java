package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Page<Book> getBooks(Pageable pageable);

    Book getBookById(Integer id);

    void add(Book book);

    void delete(Book book);

    Book getByUUID(String UUID);

    List<Book> getBestsellersCriteriaBuilder(Double fromRate, Integer publisherId, Integer authorId);

    List<Book> getByPriceIntervalCriteriaBuilder(Double minPrice, Double maxPrice, Integer publisherId, Integer authorId);

    List<Book> getBestsellersSpecification(Double fromRate, Integer publisherId, Integer authorId);

    List<Book> getByPriceIntervalSpecification(Double minPrice, Double maxPrice, Integer publisherId, Integer authorId);

    List<Book> getBestsellersQueryDsl(Double fromRate, Integer publisherId, Integer authorId);

    List<Book> getByPriceIntervalQueryDsl(Double minPrice, Double maxPrice, Integer publisherId, Integer authorId);

}

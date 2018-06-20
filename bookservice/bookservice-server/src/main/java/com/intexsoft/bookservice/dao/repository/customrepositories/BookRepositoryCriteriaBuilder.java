package com.intexsoft.bookservice.dao.repository.customrepositories;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Publisher;

import java.util.List;

public interface BookRepositoryCriteriaBuilder {

    List<Book> getBestSellers(Double fromRate, Publisher publisher, Author author);

    List<Book> getBooksByPriceInterval(Double minPrice, Double maxPrice, Publisher publisher, Author author);
}

package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    void add(Author author);

    void delete(Author author);

    Optional<Author> getAuthorByID(Integer id);

    Author getByUUID(String UUID);

}

package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AuthorService {

    Page<Author> getAuthors(Pageable pageable);

    void add(Author author);

    void delete(Author author);

    Optional<Author> getAuthorByID(Integer id);

    Author getByUUID(String UUID);

}

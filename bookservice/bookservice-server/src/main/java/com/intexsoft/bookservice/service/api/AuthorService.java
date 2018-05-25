package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.entity.Author;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    void add(Author author);

    void delete(Author author);

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    Optional<Author> getAuthorByID(Integer id);

    @PreAuthorize("hasRole('ADMIN')")
    Author getByUUID(String UUID);

}

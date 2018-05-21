package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.entity.Author;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    @PreAuthorize("hasRole('ADMIN') OR hasRole('customer')")
    List<Author> getAllAuthors();

    @PreAuthorize("hasRole('ADMIN')")
    void add(Author author);

    @PreAuthorize("hasRole('ADMIN')")
    void delete(Author author);

    @PreAuthorize("hasRole('ADMIN') OR hasRole('customer')")
    Optional<Author> getAuthorByID(Integer id);

    @PreAuthorize("hasRole('ADMIN')")
    Author getByUUID(String UUID);

}

package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.entity.Author;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    @Transactional()
    List<Author> getAllAuthors();

    @Transactional
    void add(Author author);

    @Transactional
    void delete(Author author);

    @Transactional
    Optional<Author> getAuthorByID(Integer id);

    @Transactional
    void exportToDB(ArrayList<Author> authors);
}

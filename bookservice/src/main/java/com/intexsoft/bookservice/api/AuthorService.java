package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.importentitiy.ImportAuthor;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();

    void add(Author author);

    void delete(Author author);

    Optional<Author> getAuthorByID(Integer id);

    void importToDB(List<ImportAuthor> authors);

    Author getByUUID(String UUID);

}

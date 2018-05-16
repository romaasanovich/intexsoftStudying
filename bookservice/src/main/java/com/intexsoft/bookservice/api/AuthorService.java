package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.jsonentitiy.AuthorJson;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();

    void add(Author author);

    void delete(Author author);

    Optional<Author> getAuthorByID(Integer id);

    void exportToDB(List<AuthorJson> authors);

    Author getByUUID(String UUID);

}

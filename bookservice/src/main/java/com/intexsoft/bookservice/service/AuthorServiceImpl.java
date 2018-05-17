package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.AuthorService;
import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.importentitiy.ImportAuthor;
import com.intexsoft.bookservice.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void add(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Optional<Author> getAuthorByID(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author getByUUID(String UUID) {
        return authorRepository.findByUUID(UUID);
    }

    @Override
    public void importToDB(List<ImportAuthor> authors) {
        for (ImportAuthor importAuthor : authors) {
            Author author = authorRepository.findByUUID(importAuthor.getUuid());
            if (author == null) {
                author = new Author();
            }
            author.setName(importAuthor.getName());
            author.setBio(importAuthor.getBio());
            author.setBirthDay(importAuthor.getBirthDay());
            author.setUuid(importAuthor.getUuid());
            authorRepository.save(author);
        }
    }

}

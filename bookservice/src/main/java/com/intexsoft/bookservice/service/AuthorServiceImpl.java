package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.AuthorService;
import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.jsonentitiy.AuthorJson;
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
    public void exportToDB(List<AuthorJson> authors) {
        for (AuthorJson authorJson : authors) {
            Author author = authorRepository.findByUUID(authorJson.getUuid());
            if (author == null) {
                author = new Author();
            }
            author.setName(authorJson.getName());
            author.setBio(authorJson.getBio());
            author.setBirthDay(authorJson.getBirthDay());
            author.setUuid(authorJson.getUuid());
            authorRepository.save(author);
        }
    }

}

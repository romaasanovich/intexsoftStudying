package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.repository.AuthorRepository;
import com.intexsoft.bookservice.api.AuthorService;
import com.intexsoft.bookservice.utill.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Transactional()
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Transactional
    @Override
    public void add(Author author) {
        authorRepository.save(author);
    }


    @Transactional
    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }


    @Transactional
    @Override
    public Optional<Author> getAuthorByID(Integer id) {
        return authorRepository.findById(id);
    }


    @Transactional
    @Override
    public void exportToDB(ArrayList<Author> authors) {
        for (Author author : authors) {
            if (authorRepository.findByUUID(author.getUuid()) == null) {
                authorRepository.create(author.getUuid(), author.getName(), author.getBio(), Converter.fromDateToString(author.getBirthDay()));
            } else {
                authorRepository.update(author.getUuid(), author.getName(), author.getBio(), Converter.fromDateToString(author.getBirthDay()), author.getId().toString());
            }
        }
    }

}

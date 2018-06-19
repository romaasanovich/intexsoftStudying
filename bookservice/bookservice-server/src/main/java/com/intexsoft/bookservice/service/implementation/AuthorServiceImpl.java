package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.repository.AuthorRepository;
import com.intexsoft.bookservice.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Page<Author> getAuthors(int page, int size) {
        return authorRepository.findAll(PageRequest.of(page, size));
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

}

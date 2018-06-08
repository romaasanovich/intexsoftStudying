package com.intexsoft.bookservice.web.controller;


import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.service.api.AuthorService;
import com.intexsoft.bookservice.web.dto.entity.AuthorDto;
import com.intexsoft.bookservice.web.dto.service.api.AuthorDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorDtoService authorDtoService;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/authors")
    List<AuthorDto> getAuthors() {
        return authorDtoService.getListAuthorsDto(authorService.getAllAuthors());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/author")
    public void addAuthor(@RequestBody Author author) {
        author.setUuid(UUID.randomUUID().toString());
        authorService.add(author);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/author/{id}")
    public void deleteAuthor(@PathVariable(name = "id") Integer id) {
        Author author = authorService.getAuthorByID(id).get();
        authorService.delete(author);
    }

}

package com.intexsoft.bookservice.web.controller;


import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping(path = "/authors")
    List<Author> getAuthors(){
        return authorService.getAllAuthors();
    }

}

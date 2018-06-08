package com.intexsoft.bookservice.web.dto.service.api;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.web.dto.entity.AuthorDto;

import java.util.List;

public interface AuthorDtoService {
    List<AuthorDto> getListAuthorsDto(List<Author> authors);

    AuthorDto toDto(Author author);
}

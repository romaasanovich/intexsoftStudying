package com.intexsoft.bookservice.web.dto.service.implementation;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.web.dto.entity.AuthorDto;
import com.intexsoft.bookservice.web.dto.service.api.AuthorDtoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorDtoServiceImpl implements AuthorDtoService {

    @Override
    public List<AuthorDto> getListAuthorsDto(List<Author> authors) {
        List<AuthorDto> authorsDto = new ArrayList<>();
        for (Author author : authors) {
            authorsDto.add(toDto(author));
        }
        return authorsDto;
    }

    @Override
    public AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setBio(author.getBio());
        authorDto.setBirthDay(author.getBirthDay());
        return authorDto;
    }


}

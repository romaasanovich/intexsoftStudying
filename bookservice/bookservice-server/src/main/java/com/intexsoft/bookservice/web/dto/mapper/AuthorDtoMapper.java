package com.intexsoft.bookservice.web.dto.mapper;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.web.dto.entity.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoMapper extends AbstractDtoMapper<Author, AuthorDto> {

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

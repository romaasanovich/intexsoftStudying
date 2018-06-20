package com.intexsoft.bookservice.web.dto.mapper;

import org.springframework.data.domain.Page;

public abstract class AbstractDtoMapper<Object, Dto> {

    public Page<Dto> toPageDto(Page<Object> objectPage) {
        Page<Dto> dtoPage = objectPage.map(this::toDto);
        return dtoPage;
    }

    public abstract Dto toDto(Object object);
}

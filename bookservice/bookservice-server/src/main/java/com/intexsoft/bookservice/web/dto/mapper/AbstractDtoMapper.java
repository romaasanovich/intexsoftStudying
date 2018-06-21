package com.intexsoft.bookservice.web.dto.mapper;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDtoMapper<Object, Dto> {


    public Page<Dto> toPageDto(Page<Object> objectPage) {
        Page<Dto> dtoPage = objectPage.map(this::toDto);
        return dtoPage;
    }

    public List<Dto> toDtoList(List<Object> objectList) {
        return objectList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public abstract Dto toDto(Object object);
}

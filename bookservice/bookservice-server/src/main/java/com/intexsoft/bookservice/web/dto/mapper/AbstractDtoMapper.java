package com.intexsoft.bookservice.web.dto.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

//T is object, K is Dto Object of T
public abstract class AbstractDtoMapper<T, K> {

    public List<K> toDtoList(List<T> objectList) {
        List<K> dtoList = new ArrayList<>();
        for (T t : objectList) {
            dtoList.add(toDto(t));
        }
        return dtoList;
    }

    public Page<K> toPageDto(Page<T> objectPage) {
        List<K> dtoList = new ArrayList<>();
        for (T t : objectPage) {
            dtoList.add(toDto(t));
        }
        Page<K> dtoPage = new PageImpl<>(dtoList, Pageable.unpaged(), objectPage.getTotalElements());
        return dtoPage;
    }

    public abstract K toDto(T t);
}

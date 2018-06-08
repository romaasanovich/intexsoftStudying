package com.intexsoft.bookservice.web.dto.mapper;

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

    public abstract K toDto(T t);
}

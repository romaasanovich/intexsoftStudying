package com.intexsoft.bookservice.utill;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.entity.aentity.AbstractEntity;

import java.io.IOException;
import java.util.List;


public class Converter <T extends AbstractEntity> {

    public Book[] fromJsonToEntityList(String jsonLine) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        Book[] list =mapper.readValue(jsonLine, Book[].class);
        return list;
    }



}

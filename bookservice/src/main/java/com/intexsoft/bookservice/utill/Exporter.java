package com.intexsoft.bookservice.utill;

import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.entity.aentity.AbstractEntity;

import java.io.IOException;
import java.util.List;

public class Exporter<T extends AbstractEntity>{


    public Book[] exprot(String path) throws IOException {
        Reader reader = new Reader();
        String jsonString = reader.readFile(path);
        Converter<Book> converter = new Converter<>();
        return converter.fromJsonToEntityList(jsonString);
    }


}

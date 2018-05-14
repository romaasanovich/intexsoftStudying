package com.intexsoft.bookservice.service;

import com.google.gson.internal.LinkedTreeMap;
import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.repository.BookRepository;
import com.intexsoft.bookservice.utill.Converter;
import com.intexsoft.bookservice.utill.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class BookServiceImpl implements BookService {
    private static final String JSON_PATH = "/home/INTEXSOFT/roman.asanovich/intexsoftStudying/bookservice/src/main/resources/books.json";

    @Autowired
    private BookRepository bookRepository;

    @Transactional()
    @Override
    public List<Book> getAllBooks() {
        return  bookRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Book> getBookByID(Integer id) {
        return bookRepository.findById(id);
    }


    @Transactional
    @Override
    public void exportToDb(){
        Reader reader = new Reader();
        Converter converter = new Converter();
        try {
            Book[] books = converter.fromJsonToEntityList(reader.readFile(JSON_PATH));
//            bookRepository.saveAll(books);

        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}

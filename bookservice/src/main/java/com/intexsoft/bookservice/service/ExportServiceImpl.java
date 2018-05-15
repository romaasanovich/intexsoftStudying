package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.AuthorService;
import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.api.ExportService;
import com.intexsoft.bookservice.api.PublisherService;
import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.entity.EntitiesRep;
import com.intexsoft.bookservice.entity.Publisher;
import com.intexsoft.bookservice.entity.aentity.AbstractEntity;
import com.intexsoft.bookservice.utill.Converter;
import com.intexsoft.bookservice.utill.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class ExportServiceImpl implements ExportService {

    private static final String JSON_PATH = "/home/INTEXSOFT/roman.asanovich/intexsoftStudying/bookservice/src/main/resources/books.json";

    @Autowired
    PublisherService publisherService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @Transactional
    @Override
    public void exportToDb() {
        Reader reader = new Reader();
        Converter converter = new Converter();
        try {
            EntitiesRep entitiesRep = converter.fromJsonToEntityRep(reader.readFile(JSON_PATH));
            ArrayList<Book> books = getEntityList(Book.class, entitiesRep);
            ArrayList<Author> authors = getEntityList(Author.class, entitiesRep);
            ArrayList<Publisher> publishers = getEntityList(Publisher.class, entitiesRep);
            publisherService.exportToDB(publishers);
            authorService.exportToDB(authors);
            bookService.exportToDB(books);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    private <T extends AbstractEntity> ArrayList<T> getEntityList(Class<T> clas, EntitiesRep entitiesRep) {
        Class<T> clazz = clas;
        ArrayList<T> books = new ArrayList<>();
        for (AbstractEntity abstractEntity : entitiesRep.getAbstractEntities()) {
            if (abstractEntity.getClass().equals(clazz)) {
                books.add((T) abstractEntity);
            }
        }
        return books;
    }

}

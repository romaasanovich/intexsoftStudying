package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.AuthorService;
import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.api.ExportService;
import com.intexsoft.bookservice.api.PublisherService;
import com.intexsoft.bookservice.jsonentitiy.AuthorJson;
import com.intexsoft.bookservice.jsonentitiy.BookJson;
import com.intexsoft.bookservice.jsonentitiy.PublisherJson;
import com.intexsoft.bookservice.jsonentitiy.repository.EntityJsonRepository;
import com.intexsoft.bookservice.utill.Converter;
import com.intexsoft.bookservice.utill.PropertyWorker;
import com.intexsoft.bookservice.utill.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    PublisherService publisherService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    private static final String JSON_PATH_PROP = "jsonExport";
    private final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Transactional
    @Override
    public String exportToDb() {
        try {
            PropertyWorker pW = new PropertyWorker();
            Reader reader = new Reader();
            Converter converter = new Converter();
            EntityJsonRepository entityRep = converter.fromJsonToEntityRep(reader.readFile(pW.getProperty(JSON_PATH_PROP)));
            List<BookJson> books = entityRep.getBooks();
            List<AuthorJson> authors = entityRep.getAuthors();
            List<PublisherJson> publishers = entityRep.getPublishers();
            bookService.exportToDB(books);
            publisherService.exportToDB(publishers);
            authorService.exportToDB(authors);
            return "Success!!!";
        } catch (Exception ex) {
            logger.error("Error: ", ex);
            return "Error!!!";
        }
    }

}


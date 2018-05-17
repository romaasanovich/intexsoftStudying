package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.AuthorService;
import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.api.ImportService;
import com.intexsoft.bookservice.api.PublisherService;
import com.intexsoft.bookservice.importentitiy.ImportAuthor;
import com.intexsoft.bookservice.importentitiy.ImportBook;
import com.intexsoft.bookservice.importentitiy.ImportPublisher;
import com.intexsoft.bookservice.importentitiy.repository.ImportEntityRepository;
import com.intexsoft.bookservice.utill.Converter;
import com.intexsoft.bookservice.utill.PropertyWorker;
import com.intexsoft.bookservice.utill.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
//@Component
@Profile("xmlImpl")
public class ImportServiceXmlImpl implements ImportService {

    @Autowired
    PublisherService publisherService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;
    private static final String XML_PATH_PROP = "xmlImport";
    private final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Transactional
    @Override
    public String importToDb() {
        try {
            PropertyWorker pW = new PropertyWorker();
            Reader reader = new Reader();
            Converter converter = new Converter();
            ImportEntityRepository entityRep = converter.fromXmlToEntityRep(reader.getFile(pW.getProperty(XML_PATH_PROP)));
            List<ImportBook> books = entityRep.getBooks();
            List<ImportAuthor> authors = entityRep.getAuthors();
            List<ImportPublisher> publishers = entityRep.getPublishers();
            bookService.importToDB(books);
            publisherService.importToDB(publishers);
            authorService.importToDB(authors);
            return "Success!!!";
        } catch (Exception ex) {
            logger.error("Error: ", ex);
            return "Error!!!";
        }
    }
}


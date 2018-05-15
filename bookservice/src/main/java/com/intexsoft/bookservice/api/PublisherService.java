package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.entity.Publisher;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PublisherService {

    @Transactional()
    List<Publisher> getAllPublishers();

    @Transactional
    void add(Publisher publisher);

    @Transactional
    void delete(Publisher publisher);

    @Transactional
    Optional<Publisher> getPublisherByID(Integer id);

    @Transactional
    void exportToDB(ArrayList<Publisher> publishers);
}

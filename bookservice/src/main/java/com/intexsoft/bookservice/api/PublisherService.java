package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.entity.Publisher;
import com.intexsoft.bookservice.importentitiy.ImportPublisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    void add(Publisher publisher);

    void delete(Publisher publisher);

    Optional<Publisher> getPublisherByID(Integer id);

    Publisher getByUUID(String UUID);

    void importToDB(List<ImportPublisher> publishers);
}

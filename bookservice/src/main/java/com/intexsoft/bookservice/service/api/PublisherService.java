package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    void add(Publisher publisher);

    void delete(Publisher publisher);

    Optional<Publisher> getPublisherByID(Integer id);

    Publisher getByUUID(String UUID);


}

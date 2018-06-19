package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Publisher;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PublisherService {

    Page<Publisher> getPublishers(int page, int size);

    Optional<Publisher> getPublisherByID(Integer id);

    void add(Publisher publisher);

    void delete(Publisher publisher);

    Publisher getByUUID(String UUID);

}

package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PublisherService {

    Page<Publisher> getPublishers(Pageable pageable);

    Optional<Publisher> getPublisherByID(Integer id);

    void add(Publisher publisher);

    void delete(Publisher publisher);

    Publisher getByUUID(String UUID);

}

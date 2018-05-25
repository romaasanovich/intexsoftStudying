package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Publisher;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    Optional<Publisher> getPublisherByID(Integer id);

    void add(Publisher publisher);

    void delete(Publisher publisher);

    @PreAuthorize("hasRole('ADMIN')")
    Publisher getByUUID(String UUID);

}

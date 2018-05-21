package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.entity.Publisher;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    @PreAuthorize("hasRole('ADMIN') OR hasRole('customer')")
    List<Publisher> getAllPublishers();

    @PreAuthorize("hasRole('ADMIN') OR hasRole('customer')")
    Optional<Publisher> getPublisherByID(Integer id);

    @PreAuthorize("hasRole('ADMIN')")
    void add(Publisher publisher);

    @PreAuthorize("hasRole('ADMIN')")
    void delete(Publisher publisher);

    @PreAuthorize("hasRole('ADMIN')")
    Publisher getByUUID(String UUID);


}

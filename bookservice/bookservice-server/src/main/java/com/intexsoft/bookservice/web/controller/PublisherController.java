package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.service.api.PublisherService;
import com.intexsoft.bookservice.web.dto.entity.PublisherDto;
import com.intexsoft.bookservice.web.dto.mapper.PublisherDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private PublisherDtoMapper publisherDtoMapper;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/publishers")
    public List<PublisherDto> getPublishers() {
        return publisherDtoMapper.toDtoList(publisherService.getAllPublishers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/publisher")
    public void addPublisher(@RequestBody Publisher publisher) {
        publisher.setUuid(UUID.randomUUID().toString());
        publisherService.add(publisher);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/publisher/{id}")
    public void deletePublisher(@PathVariable(name = "id") Integer id) {
        Publisher publisher = publisherService.getPublisherByID(id).get();
        publisherService.delete(publisher);
    }
}

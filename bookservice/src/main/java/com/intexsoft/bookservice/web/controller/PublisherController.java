package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.entity.Publisher;
import com.intexsoft.bookservice.service.api.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @PostMapping(path = "/publisher/add", params = {"name"})
    public void addPublisher(@RequestParam(value = "name") String  name) {
        Publisher publisher = new Publisher();
        publisher.setUuid(UUID.randomUUID().toString());
        publisher.setName(name);
        publisherService.add(publisher);
    }

    @DeleteMapping(path = "/publisher/del", params = {"id"})
    public void addPublisher(@RequestParam(value = "id") Integer id) {
        Publisher publisher =publisherService.getPublisherByID(id).get();
        publisherService.delete(publisher);
    }
}

package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.PublisherService;
import com.intexsoft.bookservice.entity.Publisher;
import com.intexsoft.bookservice.jsonentitiy.PublisherJson;
import com.intexsoft.bookservice.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public void add(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher) {
        publisherRepository.delete(publisher);
    }

    @Override
    public Optional<Publisher> getPublisherByID(Integer id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Publisher getByUUID(String UUID) {
        return publisherRepository.findByUUID(UUID);
    }

    @Override
    public void exportToDB(List<PublisherJson> publishers) {
        for (PublisherJson publisherJson : publishers) {
            Publisher publisher = publisherRepository.findByUUID(publisherJson.getUuid());
            if (publisher == null) {
                publisher = new Publisher();
            }
            publisher.setName(publisherJson.getName());
            publisher.setUuid(publisherJson.getUuid());
            publisherRepository.save(publisher);
        }
    }
}




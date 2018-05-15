package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.PublisherService;
import com.intexsoft.bookservice.entity.Publisher;
import com.intexsoft.bookservice.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;


    @Transactional()
    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Transactional
    @Override
    public void add(Publisher publisher) {
        publisherRepository.save(publisher);
    }


    @Transactional
    @Override
    public void delete(Publisher publisher) {
        publisherRepository.delete(publisher);
    }


    @Transactional
    @Override
    public Optional<Publisher> getPublisherByID(Integer id) {
        return publisherRepository.findById(id);
    }

    @Transactional
    @Override
    public void exportToDB(ArrayList<Publisher> publishers) {
        for (Publisher publisher : publishers) {
            if (publisherRepository.findByUUID(publisher.getUuid()) == null) {
                publisherRepository.create(publisher.getUuid(), publisher.getName());
            } else {
                publisherRepository.update(publisher.getUuid(), publisher.getName(), publisher.getId().toString());
            }

        }
    }
}




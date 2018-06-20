package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.dao.repository.PublisherRepository;
import com.intexsoft.bookservice.service.api.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Page<Publisher> getPublishers(Pageable pageable) {
        return publisherRepository.findAll(pageable);
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

}




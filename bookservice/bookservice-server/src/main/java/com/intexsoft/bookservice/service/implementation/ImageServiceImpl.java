package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.repository.BookRepository;
import com.intexsoft.bookservice.dao.repository.ImageRepository;
import com.intexsoft.bookservice.service.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public List<String> getImages(Integer bookId) {
        return imageRepository.getImagesPath(bookId.toString());
    }

    @Override
    public Resource getImage(String path) {
        return applicationContext.getResource(path);
    }

    @Override
    public Resource getBookImage(Integer bookId) {
        return applicationContext.getResource("classpath:" + bookRepository.findById(bookId).get().getImagesPath().get(0));
    }

}

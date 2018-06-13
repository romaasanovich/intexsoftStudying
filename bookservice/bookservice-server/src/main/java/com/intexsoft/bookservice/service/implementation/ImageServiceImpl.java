package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.repository.ImageRepository;
import com.intexsoft.bookservice.service.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${resources.path}")
    private String resourcePath;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Resource getBookImage(Integer bookId) {
        try {
            Resource resource = applicationContext.getResource("file:" + resourcePath + imageRepository.getImagesPath(bookId.toString()).get(0).getImagePath());
            if (resource.exists()) {
                return resource;
            } else {
                return applicationContext.getResource("file:" + resourcePath + "images/books/not_found.jpg");

            }
        } catch (IndexOutOfBoundsException ex) {
            return applicationContext.getResource("file:" + resourcePath + "images/books/not_found.jpg");
        }
    }
}

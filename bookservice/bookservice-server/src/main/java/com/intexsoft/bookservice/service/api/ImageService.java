package com.intexsoft.bookservice.service.api;

import org.springframework.core.io.Resource;

import java.util.List;

public interface ImageService {

    List<String> getImages(Integer id);

    Resource getImage(String path);

    Resource getBookImage(Integer bookId);
}

package com.intexsoft.bookservice.service.api;

import org.springframework.core.io.Resource;

public interface ImageService {

    Resource getBookImage(Integer bookId);

}

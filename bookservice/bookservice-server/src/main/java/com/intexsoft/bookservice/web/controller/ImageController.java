package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.service.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @ResponseBody
    @GetMapping(path = "/image/book/{bookId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getBookImage(@PathVariable Integer bookId) {
        return imageService.getBookImage(bookId);
    }

}

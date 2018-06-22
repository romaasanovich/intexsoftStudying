package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.service.api.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @ResponseBody
    @GetMapping(path = "/image/book/{bookId}/cover", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getBookCover(@PathVariable Integer bookId) {
        return imageService.getCover(bookId);
    }

    @ResponseBody
    @GetMapping(path = "/image/book/page/{bookId}/{pageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getBookPage(@PathVariable(name = "bookId") Integer bookId, @PathVariable(name = "pageId") Integer pageId) {
        return imageService.getBookPage(bookId, pageId);
    }

    @ResponseBody
    @GetMapping(path = "/images/{bookId}")
    public List<String> getBookImageUrls(@PathVariable Integer bookId) {
        return imageService.getBookImageUrls(bookId);
    }
}

package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.BookImage;
import com.intexsoft.bookservice.dao.entity.ImageType;
import org.springframework.core.io.Resource;

import java.nio.file.Path;
import java.util.List;

public interface ImageService {

    void updateImage(String sourcePath, BookImage bookImage);

    void addImage(Book book, String importPath, ImageType imageType);

    BookImage getBookCover(Book book);

    List<BookImage> getBookPages(Book book);

    Resource getCover(Integer bookId);

    Path generateImagePath(BookImage bookPage);
}

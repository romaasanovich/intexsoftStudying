package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.BookImage;
import com.intexsoft.bookservice.dao.repository.ImageRepository;
import com.intexsoft.bookservice.service.api.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger logger = LoggerFactory.getLogger("log");

    @Value("${book.images.path}")
    private String imagesPath;

    @Value("${import.images.path}")
    private String importImagesPath;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public void updateImage(String importPath, BookImage bookImage) {
        try {
            Path sourcePath = Paths.get(importImagesPath + importPath);
            Path targetPath = generateImagePath(bookImage);
            if (Files.deleteIfExists(targetPath)) {
                Files.copy(sourcePath, targetPath);
            } else {
                Book book = bookImage.getBook();
                imageRepository.delete(bookImage);
                addImage(book, importPath, bookImage.getTypeImage());
            }
        } catch (IOException ex) {
            logger.error("Error with files or file path:", ex);
        }
    }

    @Override
    public void addImage(Book book, String imagePath, String typeImage) {
        try {
            Path sourcePath = Paths.get(importImagesPath + imagePath);
            BookImage bookImage = new BookImage();
            bookImage.setBook(book);
            bookImage.setTypeImage(typeImage);
            bookImage.setImageName(sourcePath.getFileName().toString());
            Path targetPath = generateImagePath(bookImage);
            Files.createDirectories(targetPath.getParent());
            Files.copy(sourcePath, targetPath);
            imageRepository.save(bookImage);
        } catch (IOException ex) {
            logger.error("Error with files or file path:", ex);
        }
    }


    @Override
    public BookImage getBookCover(Book book) {
        return imageRepository.getBookCover(book.getId().toString());
    }

    @Override
    public List<BookImage> getBookPages(Book book) {
        return imageRepository.getBookImages(book.getId().toString());
    }

    @Override
    public Resource getCover(Integer bookId) {
        BookImage bookImage = imageRepository.getBookCover(bookId.toString());
        return (bookImage == null) ? null : applicationContext.getResource("file:" + generateImagePath(bookImage).toString());
    }

    public Path generateImagePath(BookImage bookImage) {
        return Paths.get(imagesPath + bookImage.getBook().getUuid() + "/" + bookImage.getImageName());
    }

}

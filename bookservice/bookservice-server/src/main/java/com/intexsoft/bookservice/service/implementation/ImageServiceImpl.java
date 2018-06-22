package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.BookImage;
import com.intexsoft.bookservice.dao.entity.enums.ImageType;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger logger = LoggerFactory.getLogger("log");
    private static final String BASE_URL = "http://localhost:8080/bookservice/api/";

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
                ImageType imageType = bookImage.getImageType();
                addImage(book, importPath, imageType);
            }
        } catch (IOException ex) {
            logger.error("Error with files or file path:", ex);
        }
    }

    @Override
    public void addImage(Book book, String imagePath, ImageType imageType) {
        try {
            Path sourcePath = Paths.get(importImagesPath + imagePath);
            BookImage bookImage = new BookImage();
            bookImage.setBook(book);
            bookImage.setImageType(imageType);
            bookImage.setImageName(sourcePath.getFileName().toString());
            Path targetPath = generateImagePath(bookImage);
            if (!Files.exists(targetPath)) {
                Files.createDirectories(targetPath.getParent());
                Files.copy(sourcePath, targetPath);
            }
            imageRepository.save(bookImage);
        } catch (IOException ex) {
            logger.error("Error with files or file path:", ex);
        }
    }

    @Override
    public BookImage getBookCover(Book book) {
        return imageRepository.getBookCover(book.getId());
    }

    @Override
    public List<BookImage> getBookPages(Book book) {
        return imageRepository.getBookPages(book.getId());
    }

    @Override
    public Resource getBookPage(Integer bookId, Integer imageId) {
        BookImage image = imageRepository.getBookImage(bookId, imageId);
        return (image == null) ? null : applicationContext.getResource("file:" + generateImagePath(image).toString());
    }

    @Override
    public Resource getCover(Integer bookId) {
        BookImage bookImage = imageRepository.getBookCover(bookId);
        return (bookImage == null) ? null : applicationContext.getResource("file:" + generateImagePath(bookImage).toString());
    }

    @Override
    public List<String> getBookImageUrls(Integer bookId) {
        List<String> imageUrls = new ArrayList<>();
        BookImage bookCover = imageRepository.getBookCover(bookId);
        if (bookCover != null) {
            imageUrls.add(generateBookImageUrl(bookCover));
        }
        List<BookImage> bookPages = imageRepository.getBookPages(bookId);
        if (!bookPages.isEmpty()) {
            for (BookImage bookPage : bookPages) {
                imageUrls.add(generateBookImageUrl(bookPage));
            }
        }
        return imageUrls;
    }


    public Path generateImagePath(BookImage bookImage) {
        return Paths.get(imagesPath + bookImage.getBook().getUuid() + "/" + bookImage.getImageName());
    }

    @Override
    public void delete(BookImage bookImage) {
        imageRepository.delete(bookImage);
    }

    private String generateBookImageUrl(BookImage bookImage) {
        String bookId = bookImage.getBook().getId().toString();
        String pageId = bookImage.getId().toString();
        String url = BASE_URL + "image/book/page/" + bookId + "/" + pageId;
        return url;
    }
}

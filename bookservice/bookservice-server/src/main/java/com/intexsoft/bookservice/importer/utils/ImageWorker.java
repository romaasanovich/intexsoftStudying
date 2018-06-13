package com.intexsoft.bookservice.importer.utils;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.BookImage;
import com.intexsoft.bookservice.dao.repository.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Component
public class ImageWorker {

    private static final Logger logger = LoggerFactory.getLogger("log");

    @Autowired
    private ImageRepository imageRepository;

    @Value("${resources.path}")
    private String resourcePath;

    public void unzipImages() {
        try (ZipFile file = new ZipFile(resourcePath + "importFiles/images.zip")) {
            FileSystem fileSystem = FileSystems.getDefault();
            Enumeration<? extends ZipEntry> entries = file.entries();
            String uncompressedDirectory = resourcePath + "tempImages/";
            Files.createDirectory(fileSystem.getPath(uncompressedDirectory));
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.isDirectory()) {
                    Files.createDirectories(fileSystem.getPath(uncompressedDirectory + entry.getName()));
                } else {
                    InputStream is = file.getInputStream(entry);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    String uncompressedFileName = uncompressedDirectory + entry.getName();
                    Path uncompressedFilePath = fileSystem.getPath(uncompressedFileName);
                    Files.createFile(uncompressedFilePath);
                    FileOutputStream fileOutput = new FileOutputStream(uncompressedFileName);
                    while (bis.available() > 0) {
                        fileOutput.write(bis.read());
                    }
                    fileOutput.close();
                }
            }
        } catch (IOException e) {
            logger.error("Archive not found:", e);
        }
    }

    public void processImages(Book book, List<String> importPaths) {
        if (importPaths != null) {
            try {
                FileSystem fileSystem = FileSystems.getDefault();
                for (String importPath : importPaths) {
                    boolean isOverwritten = false;
                    String fullImportFilePath = resourcePath + "tempImages/" + importPath;
                    for (BookImage bookPath : imageRepository.getImagesPath(book.getId().toString())) {
                        if (bookPath.getImagePath().equals(importPath)) {
                            String fullBookPath = resourcePath + bookPath.getImagePath();
                            Files.deleteIfExists(fileSystem.getPath(fullBookPath));
                            Files.copy(fileSystem.getPath(fullImportFilePath), fileSystem.getPath(fullBookPath));
                            isOverwritten = true;
                            break;
                        }
                    }
                    if (!isOverwritten) {
                        Path sourcePath = fileSystem.getPath(fullImportFilePath);
                        Path targetPath = fileSystem.getPath(resourcePath + importPath);
                        Files.createDirectories(targetPath.getParent());
                        Files.copy(sourcePath, targetPath);
                        BookImage bookImage = new BookImage();
                        bookImage.setBook(book);
                        bookImage.setImagePath(importPath);
                        imageRepository.save(bookImage);
                    }
                }
            } catch (Exception ex) {
                logger.error("Error with files or file path:", ex);
            }
        }
    }
}

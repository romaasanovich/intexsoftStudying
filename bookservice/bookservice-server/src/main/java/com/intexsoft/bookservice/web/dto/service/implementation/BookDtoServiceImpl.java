package com.intexsoft.bookservice.web.dto.service.implementation;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.service.api.ReviewService;
import com.intexsoft.bookservice.web.dto.entity.BookDto;
import com.intexsoft.bookservice.web.dto.service.api.BookDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDtoServiceImpl implements BookDtoService {

    @Autowired
    private ReviewService reviewService;

    @Override
    public List<BookDto> getListBooksDto(List<Book> books) {
        List<BookDto> booksDto = new ArrayList<>();
        for (Book book : books) {
            booksDto.add(toDto(book));
        }
        return booksDto;
    }

    @Override
    public BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setDescription(book.getDescription());
        bookDto.setName(book.getName());
        bookDto.setPrice(book.getPrice());
        bookDto.setRate(getRate(book));
        bookDto.setPublisher(book.getPublisher().getName());
        bookDto.setAuthors(getListAuthors(book.getAuthors()));
        return bookDto;
    }


    private Double getRate(Book book) {
        List<Review> reviews = reviewService.getBookReview(book.getId());
        Double sumRate = 0.0;
        for (Review review : reviews) {
            sumRate += review.getRate();
        }
        Double rate = (sumRate != 0) ? (sumRate / reviews.size()) : 0.0;
        return Double.valueOf(new DecimalFormat("#.#").format(rate));
    }

    private List<String> getListAuthors(List<Author> authors) {
        List<String> authorsName = new ArrayList<>();
        for (Author author : authors) {
            authorsName.add(author.getName());
        }
        return authorsName;
    }
}

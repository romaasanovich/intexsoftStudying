package com.intexsoft.bookservice.web.dto.mapper;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.web.dto.entity.BookDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDtoMapper extends AbstractDtoMapper<Book, BookDto> {

    @Override
    public BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setDescription(book.getDescription());
        bookDto.setName(book.getName());
        bookDto.setPrice(book.getPrice());
        bookDto.setRate(book.getRate());
        bookDto.setPublishDate(book.getPublishDate());
        bookDto.setPublisher(book.getPublisher().getName());
        bookDto.setAuthors(getListAuthors(book.getAuthors()));
        return bookDto;
    }

    private List<String> getListAuthors(List<Author> authors) {
        List<String> authorsName = new ArrayList<>();
        for (Author author : authors) {
            authorsName.add(author.getName());
        }
        return authorsName;
    }
}

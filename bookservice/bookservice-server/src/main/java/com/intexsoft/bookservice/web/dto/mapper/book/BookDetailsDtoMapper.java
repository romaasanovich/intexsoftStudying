package com.intexsoft.bookservice.web.dto.mapper.book;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.web.dto.entity.book.BookDetailsDto;
import com.intexsoft.bookservice.web.dto.mapper.AbstractDtoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDetailsDtoMapper extends AbstractDtoMapper<Book, BookDetailsDto> {

    @Override
    public BookDetailsDto toDto(Book book) {
        BookDetailsDto bookDto = new BookDetailsDto();
        bookDto.setId(book.getId());
        bookDto.setDescription(book.getDescription());
        bookDto.setName(book.getName());
        bookDto.setPrice(book.getPrice());
        bookDto.setRate(book.getRate());
        bookDto.setPublishDate(book.getPublishDate());
        bookDto.setPublisher(book.getPublisher().getName());
        bookDto.setAuthors(getAuthors(book.getAuthors()));
        return bookDto;
    }

    private List<String> getAuthors(List<Author> authors) {
        List<String> authorsName = new ArrayList<>();
        for (Author author : authors) {
            authorsName.add(author.getName());
        }
        return authorsName;
    }
}

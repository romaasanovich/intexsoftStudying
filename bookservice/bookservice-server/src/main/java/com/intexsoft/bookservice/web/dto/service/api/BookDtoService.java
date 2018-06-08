package com.intexsoft.bookservice.web.dto.service.api;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.web.dto.entity.BookDto;

import java.util.List;

public interface BookDtoService {
    List<BookDto> getListBooksDto(List<Book> books);

    BookDto toDto(Book book);
}

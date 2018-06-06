package com.intexsoft.bookservice.web.dto.service;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.web.dto.entity.BookDto;

import java.util.List;

public interface BookDtoService {
    List<BookDto> getListBookDto(List<Book> books);
}

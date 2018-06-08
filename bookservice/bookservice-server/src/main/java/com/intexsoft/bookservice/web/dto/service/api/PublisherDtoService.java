package com.intexsoft.bookservice.web.dto.service.api;

import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.web.dto.entity.PublisherDto;

import java.util.List;

public interface PublisherDtoService {
    List<PublisherDto> getListPublishersDto(List<Publisher> publishers);

    PublisherDto toDto(Publisher publisher);

}

package com.intexsoft.bookservice.web.dto.mapper;

import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.web.dto.entity.PublisherDto;
import org.springframework.stereotype.Component;

@Component
public class PublisherDtoMapper extends AbstractDtoMapper<Publisher, PublisherDto> {

    @Override
    public PublisherDto toDto(Publisher publisher) {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setId(publisher.getId());
        publisherDto.setName(publisher.getName());
        return publisherDto;
    }
}

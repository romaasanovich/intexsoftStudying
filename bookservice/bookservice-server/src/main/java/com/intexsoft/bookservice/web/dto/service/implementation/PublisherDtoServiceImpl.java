package com.intexsoft.bookservice.web.dto.service.implementation;

import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.web.dto.entity.PublisherDto;
import com.intexsoft.bookservice.web.dto.service.api.PublisherDtoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherDtoServiceImpl implements PublisherDtoService {
    @Override
    public List<PublisherDto> getListPublishersDto(List<Publisher> publishers) {
        List<PublisherDto> publishersDto = new ArrayList<>();
        for (Publisher publisher : publishers) {
            publishersDto.add(toDto(publisher));
        }
        return publishersDto;
    }

    @Override
    public PublisherDto toDto(Publisher publisher) {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setId(publisher.getId());
        publisherDto.setName(publisher.getName());
        return publisherDto;
    }
}

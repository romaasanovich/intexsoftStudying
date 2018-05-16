package com.intexsoft.bookservice.utill;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.bookservice.jsonentitiy.repository.EntityJsonRepository;

import java.io.IOException;


public class Converter{

    public EntityJsonRepository fromJsonToEntityRep(String jsonLine) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        EntityJsonRepository entityJsonRepository = mapper.readValue(jsonLine, EntityJsonRepository.class);
        return entityJsonRepository;
    }

}

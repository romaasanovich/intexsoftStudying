package com.intexsoft.bookservice.utill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.entity.EntitiesRep;
import com.intexsoft.bookservice.entity.Publisher;
import com.intexsoft.bookservice.entity.aentity.AbstractEntity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Converter{

    public EntitiesRep fromJsonToEntityRep(String jsonLine) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        EntitiesRep entitiesRep = mapper.readValue(jsonLine, EntitiesRep.class);
        return entitiesRep;
    }


    public String test(List<Publisher> bookEntities) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        EntitiesRep entitiesRep = new EntitiesRep();
        List<AbstractEntity> abstractEntities =new ArrayList<>();
        for (Publisher publisher:bookEntities) {
            abstractEntities.add(publisher);
        }
        entitiesRep.setAbstractEntities((ArrayList<AbstractEntity>) abstractEntities);
        return mapper.writeValueAsString(entitiesRep);
    }

    public  static String fromDateToString(Date date){
        String result =new SimpleDateFormat("yyyy-MM-dd").format(date);
        return result;
    }


}

package com.intexsoft.bookservice.importer.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.bookservice.importer.entity.repository.ImportEntityRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;


public class Converter {

    public static ImportEntityRepository fromJsonToEntityRep(String jsonLine) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonLine, ImportEntityRepository.class);
    }

    public static ImportEntityRepository fromXmlToEntityRep(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ImportEntityRepository.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (ImportEntityRepository) jaxbUnmarshaller.unmarshal(file);
    }
}

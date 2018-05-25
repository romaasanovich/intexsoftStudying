package com.intexsoft.bookservice.utill;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.bookservice.importer.entity.repository.ImportEntityRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;


public class Converter {

    public ImportEntityRepository fromJsonToEntityRep(String jsonLine) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ImportEntityRepository importEntityRepository = mapper.readValue(jsonLine, ImportEntityRepository.class);
        return importEntityRepository;
    }

    public ImportEntityRepository fromXmlToEntityRep(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ImportEntityRepository.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ImportEntityRepository importEntityRepository = (ImportEntityRepository) jaxbUnmarshaller.unmarshal(file);
        return importEntityRepository;
    }
}

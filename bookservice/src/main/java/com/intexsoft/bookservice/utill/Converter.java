package com.intexsoft.bookservice.utill;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.bookservice.importentitiy.repository.ImportEntityRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;


public class Converter{

    public ImportEntityRepository fromJsonToEntityRep(String jsonLine) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ImportEntityRepository importEntityRepository = mapper.readValue(jsonLine, ImportEntityRepository.class);
        return importEntityRepository;
    }


    public ImportEntityRepository fromXmlToEntityRep(File file) throws  JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ImportEntityRepository.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ImportEntityRepository importEntityRepository = (ImportEntityRepository) jaxbUnmarshaller.unmarshal(file);
        return importEntityRepository;
    }

//    public String fromXMLToEntityRep(List<Author> abstractEntities) throws JAXBException {
//        ImportEntityRepository entityJsonRepository = new ImportEntityRepository();
//        List<ImportAuthor> books = new ArrayList<>();
//        for (Author author: abstractEntities) {
////            ImportBook bookJson = new ImportBook();
////            bookJson.setDescription(book.getDescription());
////            bookJson.setUuid(book.getUuid());
////            bookJson.setName(book.getName());
////            bookJson.setPrice(book.getPrice());
////            bookJson.setPublishDate(book.getPublishDate());
////            bookJson.setPublisherUUID(book.getPublisher().getUuid());
////            List<String> authorsUUID = new ArrayList<String>();
////            for (Author author : book.getAuthors()) {
////                authorsUUID.add(author.getUuid());
////            }
////            bookJson.setAuthorsUUID(authorsUUID);
////            books.add(bookJson);
////
////            ImportPublisher publisherJson = new ImportPublisher();
////            publisherJson.setUuid(publisher.getUuid());
////            publisherJson.setName(publisher.getName());
////            books.add(publisherJson);
//            ImportAuthor authorJson = new ImportAuthor();
//            authorJson.setUuid(author.getUuid());
//            authorJson.setName(author.getName());
//            authorJson.setBio(author.getBio());
//            authorJson.setBirthDay(author.getBirthDay());
//            books.add(authorJson);
//
//        }
//        entityJsonRepository.setAuthors(books);
//
//        JAXBContext jaxbContext = JAXBContext.newInstance(ImportEntityRepository.class);
//        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        jaxbMarshaller.marshal(entityJsonRepository,System.out);
//        return  "" ;
//    }
}

package com.intexsoft.bookservice.importer.importer;

import com.intexsoft.bookservice.importer.entity.repository.ImportEntityRepository;
import com.intexsoft.bookservice.importer.importer.entityimporter.EntityImporter;
import com.intexsoft.bookservice.importer.utils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class ImporterXmlImpl implements Importer {

    private static final Logger logger = LoggerFactory.getLogger("log");
    @Autowired
    private EntityImporter entityImporter;

    @Value("classpath:${xmlImportPath}")
    private Resource file;

    @Override
    public ImportType getType() {
        return ImportType.XML;
    }

    @Transactional
    @Override
    public boolean importToDb() {
        try {
            ImportEntityRepository entityRepository = Converter.fromXmlToEntityRep(file.getFile());
            entityImporter.importEntities(entityRepository);
            return true;
        } catch (IOException ex) {
            logger.error("File not found: ", ex);
            return false;
        } catch (JAXBException er) {
            logger.error("Wrong XML structure: ", er);
            return false;
        }
    }
}


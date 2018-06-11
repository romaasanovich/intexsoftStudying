package com.intexsoft.bookservice.importer.importer;

import com.intexsoft.bookservice.importer.entity.repository.ImportEntityRepository;
import com.intexsoft.bookservice.importer.importer.entityimporter.EntityImporter;
import com.intexsoft.bookservice.importer.utils.Converter;
import com.intexsoft.bookservice.importer.utils.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class ImporterJsonImpl implements Importer {

    private static final Logger logger = LoggerFactory.getLogger("log");
    @Autowired
    private EntityImporter entityImporter;

    @Value("classpath:${jsonImportPath}")
    private Resource file;

    @Override
    public TypeImport getType() {
        return TypeImport.json;
    }


    @Transactional
    @Override
    public boolean importToDb() {
        try {
            String jsonLine;
            try {
                Reader reader = new Reader();
                jsonLine = reader.readFile(file.getFile());
            } catch (IOException ex) {
                logger.error("File not found: ", ex);
                return false;
            }
            ImportEntityRepository entityRep = Converter.fromJsonToEntityRep(jsonLine);
            entityImporter.importEntities(entityRep);
            return true;
        } catch (IOException ex) {
            logger.error("Wrong Json Structure: ", ex);
            return false;
        }
    }

}


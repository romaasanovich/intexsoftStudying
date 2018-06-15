package com.intexsoft.bookservice.importer.importer.entityimporter;

import com.intexsoft.bookservice.importer.entity.repository.ImportEntityRepository;

import java.io.IOException;

public interface EntityImporter {
    void importEntities(ImportEntityRepository entityRepository) throws IOException;
}

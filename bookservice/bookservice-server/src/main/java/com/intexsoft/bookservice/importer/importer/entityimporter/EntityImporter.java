package com.intexsoft.bookservice.importer.importer.entityimporter;

import com.intexsoft.bookservice.importer.entity.repository.ImportEntityRepository;

public interface EntityImporter {
    void importEntities(ImportEntityRepository entityRepository);
}

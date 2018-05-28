package com.intexsoft.bookservice.importer.importer;

import org.springframework.security.access.prepost.PreAuthorize;

public interface Importer {

    TypeImport getType();

    @PreAuthorize("hasRole('ADMIN')")
    void importToDb();
}

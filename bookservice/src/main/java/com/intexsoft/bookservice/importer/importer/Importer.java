package com.intexsoft.bookservice.importer.importer;

import com.intexsoft.bookservice.utill.TypeImport;

public interface Importer {

    TypeImport getType();
    void importToDb();
}

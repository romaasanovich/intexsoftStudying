package com.intexsoft.bookservice.importer.importer;

public interface Importer {

    TypeImport getType();

    boolean importToDb();
}

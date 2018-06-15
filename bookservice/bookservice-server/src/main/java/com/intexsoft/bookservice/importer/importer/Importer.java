package com.intexsoft.bookservice.importer.importer;

public interface Importer {

    ImportType getType();

    boolean importToDb();
}

package com.intexsoft.bookservice.importer.importer.entityimporter.imageworker;

import com.intexsoft.bookservice.importer.entity.ImportBook;

import java.io.IOException;
import java.util.List;

public interface ImageWorker {
    void importImages(List<ImportBook> books) throws IOException;
}

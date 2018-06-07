package com.intexsoft.bookservice.importer.executor;

import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.TypeImport;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public interface ImportExecutor {
    boolean importEntities(TypeImport typeImport) throws InterruptedException;

    void setLock(ReentrantLock lock);

    void setImporters(List<Importer> importers);
}

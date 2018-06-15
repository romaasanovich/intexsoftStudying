package com.intexsoft.bookservice.importer.executor;

import com.intexsoft.bookservice.importer.importer.ImportType;
import com.intexsoft.bookservice.importer.importer.Importer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public interface ImportExecutor {
    boolean importEntities(ImportType importType) throws InterruptedException;

    void setLock(ReentrantLock lock);

    void setImporters(List<Importer> importers);
}

package com.intexsoft.bookservice.importer.executor;

import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.locks.ReentrantLock;

public interface ImportExecutor {
    ResponseEntity importEntities(TypeImport typeImport, Importer importService) throws InterruptedException;
    void setLock(ReentrantLock lock);
}

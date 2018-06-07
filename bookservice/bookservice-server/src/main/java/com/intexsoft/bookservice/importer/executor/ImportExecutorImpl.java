package com.intexsoft.bookservice.importer.executor;

import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class ImportExecutorImpl implements ImportExecutor {

    private static final Logger logger = LoggerFactory.getLogger("log");
    private static ReentrantLock lock = new ReentrantLock();

    @Autowired
    private List<Importer> importers;

    @Override
    public boolean importEntities(TypeImport typeImport) throws InterruptedException {
        if (lock.tryLock()) {
            logger.info("Thread locked the lock");
            try {
                logger.info("Start import to db");
                Thread.sleep(2500);
                logger.info("Import is running");
                Importer importService = importers.stream().filter((s) -> s.getType().equals(typeImport)).findFirst().get();
                Boolean isImport = importService.importToDb();
                if (isImport.equals(true)) {
                    logger.info("Import is OK");
                    return true;
                } else {
                    logger.info("Import is have an error");
                    return false;
                }
            } catch (NoSuchElementException ex) {
                logger.error("Importer not found:", ex);
                return false;
            } finally {
                logger.info("Lock is unlocked");
                lock.unlock();
            }
        } else {
            logger.info("Other thread is used lock now");
            throw new AccessDeniedException("Other thread is used lock now");
        }
    }

    @Override
    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void setImporters(List<Importer> importers) {
        this.importers = importers;
    }
}



package com.intexsoft.bookservice.importer.executor;

import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

public class ImportExecutorImpl implements ImportExecutor {

    private static final Logger logger = LoggerFactory.getLogger("log");
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public ResponseEntity importEntities(TypeImport typeImport, Importer importService) throws InterruptedException {
            if (lock.tryLock()) {
                logger.info("Thread lock the lock");
                try {
                    logger.info("Start import to db");
                    Thread.sleep(5000);
                    logger.info("Import running");
                    Boolean isImport = importService.importToDb();
                    if (isImport.equals(true)) {
                        logger.info("Import is OK");
                        return new ResponseEntity(HttpStatus.OK);
                    } else {
                        logger.info("Import is have an error");
                        return new ResponseEntity(HttpStatus.BAD_REQUEST);
                    }
                } catch (NoSuchElementException ex) {
                    logger.error("Importer not found");
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
                } finally {
                    logger.info("Lock is unlocked");
                    lock.unlock();
                }
            } else {
                logger.info("Thread is used lock now");
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
    }

    @Override
    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }
}



package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/api")
public class ImportController {

    private final Logger logger = LoggerFactory.getLogger("log");
    private ReentrantLock lock = new ReentrantLock();

    @Autowired
    private List<Importer> importers;


    @PostMapping(path = "/import/{type}")
    public ResponseEntity importEntities(@PathVariable(name = "type") TypeImport typeImport) throws InterruptedException {
        if (!lock.isHeldByCurrentThread()) {
            if (lock.tryLock()) {
                logger.info("Thread lock the lock");
                try {
                    logger.info("Start import to db");
                    Thread.sleep(1000);
                    Importer importService = importers.stream().filter((s) -> s.getType().equals(typeImport)).findFirst().get();
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
        } else {
            logger.info("Thread locked another thread");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public void setImporters(List<Importer> importers) {
        this.importers = importers;
    }
}

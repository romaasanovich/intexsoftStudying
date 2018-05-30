package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/api")
public class ImportController {

    private final Logger logger = LoggerFactory.getLogger("log");
    private ReentrantLock lock = new ReentrantLock();
    @Autowired
    private List<Importer> importers;

    @Scheduled(cron = "0 0 3 * * ?")
    @PostMapping(path = "/import/{type}")
    public ResponseEntity importEntities(@PathVariable(name = "type") TypeImport typeImport) throws InterruptedException {
        if (!lock.isHeldByCurrentThread()) {
            if (lock.tryLock()) {
                logger.info("Thread lock the lock");
                try {
                    logger.info("Start import to db");
                    Thread.sleep(3000);
                    Importer importService = importers.stream().filter((s) -> s.getType().equals(typeImport)).findFirst().orElse(null);
                    if (importService != null) {
                        logger.info("Import running");
                        importService.importToDb();
                        logger.info("Import is OK");
                        return new ResponseEntity(HttpStatus.OK);
                    } else {
                        return new ResponseEntity(HttpStatus.BAD_REQUEST);
                    }
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

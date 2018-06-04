package com.intexsoft.bookservice.importer.scheduler;

import com.intexsoft.bookservice.importer.executor.ImportExecutor;
import com.intexsoft.bookservice.importer.executor.ImportExecutorImpl;
import com.intexsoft.bookservice.importer.importer.ImporterJsonImpl;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ImportScheduler {

    private final Logger logger = LoggerFactory.getLogger("log");

    @Autowired
    ImporterJsonImpl importerJson;
    ImportExecutor importExecutor = new ImportExecutorImpl();

    @Scheduled(cron = "0 * * * * *")
    public void importJson() {
        try {
            logger.info("Scheduled import");
            importExecutor.importEntities(TypeImport.json, importerJson);
        } catch (InterruptedException e) {
            logger.error("Thread is interrupted: ", e);
        }
    }
}

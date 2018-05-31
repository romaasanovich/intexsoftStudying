package com.intexsoft.bookservice.scheduler.importer;

import com.intexsoft.bookservice.importer.importer.TypeImport;
import com.intexsoft.bookservice.web.controller.ImportController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ImportScheduler {

    @Autowired
    ImportController importController;

    @Scheduled(cron = "3 * * * * ?")
    public void importJson() throws InterruptedException {
        importController.importEntities(TypeImport.json);
    }
}

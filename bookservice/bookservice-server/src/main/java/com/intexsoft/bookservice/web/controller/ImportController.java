package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.importer.executor.ImportExecutor;
import com.intexsoft.bookservice.importer.executor.ImportExecutorImpl;
import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class ImportController {

    private ImportExecutor importExecutor = new ImportExecutorImpl();

    @Autowired
    private List<Importer> importers;

    @PostMapping(path = "/import/{type}")
    public ResponseEntity importEntities(@PathVariable(name = "type") TypeImport typeImport) throws InterruptedException {
        Importer importService = importers.stream().filter((s) -> s.getType().equals(typeImport)).findFirst().orElse(null);
        if (importService != null) {
            return importExecutor.importEntities(typeImport, importService);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public void setImporters(List<Importer> importers) {
        this.importers = importers;
    }

}
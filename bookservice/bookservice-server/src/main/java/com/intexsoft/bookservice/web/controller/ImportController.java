package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.importer.executor.ImportExecutor;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class ImportController {

    @Autowired
    private ImportExecutor importExecutor;

    @PostMapping(path = "/import/{type}")
    public ResponseEntity importEntities(@PathVariable(name = "type") TypeImport typeImport) throws InterruptedException {
        try {
            return (importExecutor.importEntities(typeImport)) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (AccessDeniedException accDenEx) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public void setImportExecutor(ImportExecutor importExecutor) {
        this.importExecutor = importExecutor;
    }
}
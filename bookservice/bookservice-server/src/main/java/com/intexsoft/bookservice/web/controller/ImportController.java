package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImportController {

    @Autowired
    private List<Importer> importers;

    @GetMapping(path = "/import/{type}")
    public ResponseEntity importEntities(@PathVariable(name = "type") TypeImport typeImport) {
        Importer importService = importers.stream().filter((s) -> s.getType().equals(typeImport)).findFirst().get();
        if (importService != null) {
            importService.importToDb();
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

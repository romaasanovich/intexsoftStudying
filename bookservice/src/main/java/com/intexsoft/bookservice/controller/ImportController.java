package com.intexsoft.bookservice.controller;

import com.intexsoft.bookservice.api.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ImportController {

    @Autowired
    private ImportService importService;

    @GetMapping(path = "/import")
    public String importEntities() {
        return importService.importToDb();
    }
}

package com.intexsoft.bookservice.controller;

import com.intexsoft.bookservice.api.ImportService;
import com.intexsoft.bookservice.utill.TypeImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImportController {

    @Autowired
    private List<ImportService> importers;

    @GetMapping(path = "/import/{type}")
    public void importEntities(@PathVariable(name = "type") TypeImport typeImport)
    {
        ImportService importService = importers.stream().filter((s)-> s.getType().equals(typeImport)).findFirst().get();
        importService.importToDb();
    }
}

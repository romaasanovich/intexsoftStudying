package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.utill.TypeImport;

public interface ImportService {

    TypeImport getType();
    void importToDb();
}

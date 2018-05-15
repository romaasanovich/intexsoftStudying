package com.intexsoft.bookservice.api;

import javax.transaction.Transactional;

public interface ExportService {

    @Transactional
    void exportToDb();
}

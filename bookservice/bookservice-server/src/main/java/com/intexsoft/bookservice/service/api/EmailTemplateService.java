package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.EmailTemplate;
import com.intexsoft.bookservice.dao.entity.enums.TemplateType;

public interface EmailTemplateService {

    EmailTemplate getByTemplateType(TemplateType templateType);
}

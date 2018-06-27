package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.EmailTemplate;
import com.intexsoft.bookservice.dao.entity.enums.TemplateType;
import com.intexsoft.bookservice.dao.repository.EmailTemplateRepository;
import com.intexsoft.bookservice.service.api.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {

    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

    @Override
    public EmailTemplate getByTemplateType(TemplateType templateType) {
        return emailTemplateRepository.findByTemplateType(templateType);
    }
}

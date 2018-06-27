package com.intexsoft.bookservice.dao.repository;

import com.intexsoft.bookservice.dao.entity.EmailTemplate;
import com.intexsoft.bookservice.dao.entity.enums.TemplateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Integer> {

    @Query
    EmailTemplate findByTemplateType(TemplateType templateType);
}

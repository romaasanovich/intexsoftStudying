package com.intexsoft.bookservice.dao.entity;

import com.intexsoft.bookservice.dao.entity.enums.TemplateType;

import javax.persistence.*;

@Entity
@Table(name = "emailTemplate")
public class EmailTemplate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "emailSubject")
    private String subject;
    @Column(name = "emailBody")
    private String body;
    @Enumerated(EnumType.STRING)
    @Column(name = "templateType")
    private TemplateType templateType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public TemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(TemplateType templateType) {
        this.templateType = templateType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

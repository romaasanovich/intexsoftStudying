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
    @Column(name = "ftlCode")
    private String ftlCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "templateType")
    private TemplateType templateType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFtlCode() {
        return ftlCode;
    }

    public void setFtlCode(String ftlCode) {
        this.ftlCode = ftlCode;
    }

    public TemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(TemplateType templateType) {
        this.templateType = templateType;
    }
}

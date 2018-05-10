package com.intesxsoft.studyingproject.entity;

import com.intesxsoft.studyingproject.entity.aentity.AEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher extends AEntity {
    @Column(name = "name", length = 45)
    private String name;

    public Publisher() {
    }

    public Publisher(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

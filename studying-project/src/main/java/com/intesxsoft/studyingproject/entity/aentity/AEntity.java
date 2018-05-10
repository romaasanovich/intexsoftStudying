package com.intesxsoft.studyingproject.entity.aentity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    protected AEntity() {
    }

    public AEntity(Integer id) {
        this.id =id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

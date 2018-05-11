package com.intexsoft.bookservice.entity.aentity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbsractEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    protected AbsractEntity() {
    }

    public AbsractEntity(Integer id) {
        this.id =id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.intexsoft.bookservice.entity.aentity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name ="UUID",length = 45)
    private String uuid;

    protected AbstractEntity() {
    }

    public AbstractEntity(Integer id,String uuid) {
        this.id =id;
        this.uuid=uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

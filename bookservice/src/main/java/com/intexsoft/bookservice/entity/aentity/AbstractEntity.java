package com.intexsoft.bookservice.entity.aentity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.entity.Publisher;

import javax.persistence.*;
import java.io.Serializable;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Book.class, name = "book"),
        @JsonSubTypes.Type(value = Author.class, name = "author"),
        @JsonSubTypes.Type(value = Publisher.class, name = "publisher")
})
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

package com.intexsoft.bookservice.dao.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intexsoft.bookservice.dao.entity.aentity.AbstractEntity;
import com.intexsoft.bookservice.utils.converter.localdate.json.LocalDateDeserializer;
import com.intexsoft.bookservice.utils.converter.localdate.json.LocalDateSerializer;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "author")
public class Author extends AbstractEntity {
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "bio", length = 100)
    private String bio;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "birthDay")
    private LocalDate birthDay;

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}

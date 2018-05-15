package com.intexsoft.bookservice.entity;


import com.intexsoft.bookservice.entity.aentity.AbstractEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "author")
public class Author extends AbstractEntity {
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "bio", length = 100)
    private String bio;
    @Column(name = "birthDay")
    @Temporal(value = TemporalType.DATE)
    private Date birthDay;

    public Author() {
    }

    public Author(Integer id, String uuid, String name, String bio, Date birthDay) {
        super(id, uuid);
        this.name = name;
        this.bio = bio;
        this.birthDay = birthDay;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}

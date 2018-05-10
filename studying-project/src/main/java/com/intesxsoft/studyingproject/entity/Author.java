package com.intesxsoft.studyingproject.entity;

import com.intesxsoft.studyingproject.entity.aentity.AEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "author")
public class Author extends AEntity {
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "bio", length = 100)
    private String bio;
    @Column(name = "birthDay")
    @Temporal(value = TemporalType.DATE)
    private Date birthDay;

    public Author() {
    }

    public Author(Integer id, String name, String bio, Date birthDay) {
        super(id);
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

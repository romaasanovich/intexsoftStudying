package com.intexsoft.bookservice.jsonentitiy;

import java.util.Date;
import java.util.List;

public class BookJson {
    private String uuid;
    private String name;
    private String description;
    private Double price;
    private Date publishDate;
    private String publisherUUID;
    private List<String> authorsUUID;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


    public String getPublisherUUID() {
        return publisherUUID;
    }

    public void setPublisherUUID(String publisherUUID) {
        this.publisherUUID = publisherUUID;
    }

    public List<String> getAuthorsUUID() {
        return authorsUUID;
    }

    public void setAuthorsUUID(List<String> authorsUUID) {
        this.authorsUUID = authorsUUID;
    }
}

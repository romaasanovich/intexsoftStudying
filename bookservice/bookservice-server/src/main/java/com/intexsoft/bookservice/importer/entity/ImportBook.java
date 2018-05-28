package com.intexsoft.bookservice.importer.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;


@XmlRootElement
public class ImportBook {
    private String uuid;
    private String name;
    private String description;
    private Double price;
    private Date publishDate;
    private String publisherUUID;
    private List<String> authorsUUID;

    @XmlElement
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlElement
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @XmlElement
    public String getPublisherUUID() {
        return publisherUUID;
    }

    public void setPublisherUUID(String publisherUUID) {
        this.publisherUUID = publisherUUID;
    }

    @XmlElementWrapper(name = "authorsUUID")
    @XmlElement(name = "authorUUID")
    public List<String> getAuthorsUUID() {
        return authorsUUID;
    }

    public void setAuthorsUUID(List<String> authorsUUID) {
        this.authorsUUID = authorsUUID;
    }
}

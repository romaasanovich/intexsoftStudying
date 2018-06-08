package com.intexsoft.bookservice.importer.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@XmlRootElement
public class ImportBook {
    private String uuid;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate publishDate;
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
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlElement
    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
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

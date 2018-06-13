package com.intexsoft.bookservice.importer.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intexsoft.bookservice.utils.converter.localdate.json.LocalDateDeserializer;
import com.intexsoft.bookservice.utils.converter.localdate.json.LocalDateSerializer;
import com.intexsoft.bookservice.utils.converter.localdate.xml.LocalDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@XmlRootElement
public class ImportBook {
    private String uuid;
    private String name;
    private String description;
    private BigDecimal price;
    private String publisherUUID;
    private List<String> authorsUUID;
    private List<String> imagesName;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate publishDate;

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
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
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

    @XmlElementWrapper(name = "imagesName")
    @XmlElement(name = "imageName")
    public List<String> getImagesName() {
        return imagesName;
    }

    public void setImagesName(List<String> imagesName) {
        this.imagesName = imagesName;
    }
}

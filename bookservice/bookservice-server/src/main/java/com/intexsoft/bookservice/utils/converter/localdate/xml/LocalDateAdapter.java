package com.intexsoft.bookservice.utils.converter.localdate.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter.toPattern());


    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, dateTimeFormatter);
    }

    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}
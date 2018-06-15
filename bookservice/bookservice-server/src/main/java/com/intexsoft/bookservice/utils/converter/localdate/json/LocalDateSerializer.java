package com.intexsoft.bookservice.utils.converter.localdate.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends StdSerializer<LocalDate> {

    private SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter.toPattern());

    public LocalDateSerializer() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(value.format(dateTimeFormatter));
    }

}
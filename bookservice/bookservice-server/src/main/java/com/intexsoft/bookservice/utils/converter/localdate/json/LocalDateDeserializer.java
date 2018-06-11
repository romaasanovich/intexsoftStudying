package com.intexsoft.bookservice.utils.converter.localdate.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private SimpleDateFormat formatter
            = new SimpleDateFormat("M/d/yyyy");
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter.toPattern());


    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return LocalDate.parse(parser.readValueAs(String.class), dateTimeFormatter);
    }
}

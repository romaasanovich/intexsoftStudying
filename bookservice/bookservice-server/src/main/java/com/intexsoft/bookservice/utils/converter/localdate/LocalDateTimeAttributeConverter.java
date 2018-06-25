package com.intexsoft.bookservice.utils.converter.localdate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        } else {
            return Timestamp.valueOf(localDateTime);
        }
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dateTime) {
        return (dateTime == null ? null : dateTime.toLocalDateTime());
    }
}

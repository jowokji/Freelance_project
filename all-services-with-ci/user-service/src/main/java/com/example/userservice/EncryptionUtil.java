package com.example.userservice;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Base64;

@Converter
public class EncryptionUtil implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String value) {
        if (value == null) return null;
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    @Override
    public String convertToEntityAttribute(String dbValue) {
        if (dbValue == null) return null;
        try {
            return new String(Base64.getDecoder().decode(dbValue));
        } catch (IllegalArgumentException e) {
            return dbValue;
        }
    }
}

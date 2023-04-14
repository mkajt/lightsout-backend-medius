package com.medius.lightsout.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.List;

@Converter()
public class ListIntToStringConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> integers) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : integers) {
            sb.append(integer);
        }
        return sb.toString();
    }

    @Override
    public List<Integer> convertToEntityAttribute(String s) {
        List<Integer> matrix = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            matrix.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        return matrix;
    }
}

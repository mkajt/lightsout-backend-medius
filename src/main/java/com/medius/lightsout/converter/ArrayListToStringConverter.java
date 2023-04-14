package com.medius.lightsout.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;

@Converter()
public class ArrayListToStringConverter implements AttributeConverter<ArrayList<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(ArrayList<Integer> integers) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : integers) {
            sb.append(integer);
        }
        String matrix = sb.toString();
        return matrix;
    }

    @Override
    public ArrayList<Integer> convertToEntityAttribute(String s) {
        ArrayList<Integer> matrix = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            matrix.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        return matrix;
    }
}

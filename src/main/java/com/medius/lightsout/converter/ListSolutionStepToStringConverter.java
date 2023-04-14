package com.medius.lightsout.converter;

import com.medius.lightsout.entity.Solution_step;
import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.List;

public class ListSolutionStepToStringConverter implements AttributeConverter<List<Solution_step>, String[]> {

    @Override
    public String[] convertToDatabaseColumn(List<Solution_step> solutionSteps) {
        return null;
    }

    @Override
    public List<Solution_step> convertToEntityAttribute(String[] s) {
        return null;
    }
}

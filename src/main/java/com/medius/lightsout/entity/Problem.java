package com.medius.lightsout.entity;

import com.medius.lightsout.converter.ArrayListToStringConverter;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer problemId;

    @Convert(converter = ArrayListToStringConverter.class)
    @Column(nullable = false)
    private ArrayList<Integer> matrix;

    public Problem(ArrayList<Integer> matrix) {
        this.matrix = matrix;
    }

    public Problem() {
    }


    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public ArrayList<Integer> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<Integer> matrix) {
        this.matrix = matrix;
    }
}

package com.medius.lightsout.entity;

import com.medius.lightsout.converter.ArrayListToStringConverter;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problemId")
    private Integer problemId;

    @Convert(converter = ArrayListToStringConverter.class)
    @Column(name = "matrix", nullable = false)
    private ArrayList<Integer> matrix;

    @Column(name = "matrixSize", nullable = false)
    private Integer matrixSize;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "solutionId_fk", referencedColumnName = "problemId")
    private ArrayList<Solution> solution;*/

    public Problem(ArrayList<Integer> matrix, Integer matrixSize) {
        this.matrix = matrix;
        this.matrixSize = matrixSize;
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


    public Integer getMatrixSize() {
        return matrixSize;
    }

    public void setMatrixSize(Integer matrixSize) {
        this.matrixSize = matrixSize;
    }

}

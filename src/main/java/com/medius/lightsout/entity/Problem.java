package com.medius.lightsout.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problemId")
    private Integer problemId;

    @Column(name = "matrix", nullable = false)
    private List<Integer> matrix;

    @Column(name = "matrixSize", nullable = false)
    private Integer matrixSize;

    public Problem(List<Integer> matrix, Integer matrixSize) {
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

    public List<Integer> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<Integer> matrix) {
        this.matrix = matrix;
    }


    public Integer getMatrixSize() {
        return matrixSize;
    }

    public void setMatrixSize(Integer matrixSize) {
        this.matrixSize = matrixSize;
    }

}

package com.medius.lightsout.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

    private int problemId;
    private ArrayList<Integer> matrix;

    public Problem() {
    }

    public Problem(int problemId, ArrayList<Integer> matrix) {
        this.problemId = problemId;
        this.matrix = matrix;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public ArrayList<Integer> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<Integer> matrix) {
        this.matrix = matrix;
    }
}

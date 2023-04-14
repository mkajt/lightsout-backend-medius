package com.medius.lightsout.entity;

public class Solution {

    private Integer solutionId;
    private Integer problemId;

    public Solution() {
    }

    public Solution(int solutionId, int problemId) {
        this.solutionId = solutionId;
        this.problemId = problemId;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }
}

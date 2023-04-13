package com.medius.lightsout.entity;

import java.util.ArrayList;

public class Solution_step {
    private int solutionStepId;
    private int solutionId;
    private ArrayList<Integer> solutionSteps;

    public Solution_step() {
    }

    public Solution_step(int solutionStepId, int solutionId, ArrayList<Integer> solutionSteps) {
        this.solutionStepId = solutionStepId;
        this.solutionId = solutionId;
        this.solutionSteps = solutionSteps;
    }

    public int getSolutionStepId() {
        return solutionStepId;
    }

    public void setSolutionStepId(int solutionStepId) {
        this.solutionStepId = solutionStepId;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public ArrayList<Integer> getSolutionSteps() {
        return solutionSteps;
    }

    public void setSolutionSteps(ArrayList<Integer> solutionSteps) {
        this.solutionSteps = solutionSteps;
    }
}

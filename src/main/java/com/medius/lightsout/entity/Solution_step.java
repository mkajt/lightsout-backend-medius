package com.medius.lightsout.entity;

import com.medius.lightsout.converter.ArrayListToStringConverter;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity(name = "solution_step")
public class Solution_step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solutionStepId")
    private Integer solutionStepId;

    @ManyToOne()
    @JoinColumn(name = "solutionId", referencedColumnName = "solutionId")
    private Solution solution;

    //@Column(nullable = false)
    @Convert(converter = ArrayListToStringConverter.class)
    @Column(name = "solutionSteps")
    private ArrayList<Integer> solutionSteps;

    public Solution_step() {
    }

    public Solution_step(ArrayList<Integer> solutionSteps) {
        this.solutionSteps = solutionSteps;
    }

    public Integer getSolutionStepId() {
        return solutionStepId;
    }

    public void setSolutionStepId(Integer solutionStepId) {
        this.solutionStepId = solutionStepId;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solutionId) {
        this.solution = solution;
    }

    public ArrayList<Integer> getSolutionSteps() {
        return solutionSteps;
    }

    public void setSolutionSteps(ArrayList<Integer> solutionSteps) {
        this.solutionSteps = solutionSteps;
    }
}

package com.medius.lightsout.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.medius.lightsout.converter.ListIntToStringConverter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "solution_step")
public class Solution_step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solutionStepId")
    private Integer solutionStepId;

    @ManyToOne()
    @JoinColumn(name = "solutionId")
    @JsonBackReference
    private Solution solution;

    @Convert(converter = ListIntToStringConverter.class)
    @Column(name = "solutionSteps")
    private List<Integer> solutionSteps;

    @Column(name = "sequence")
    private Integer sequence;

    public Solution_step() {
    }

    public Solution_step(List<Integer> solutionSteps, Integer sequence, Solution solution) {
        this.solutionSteps = solutionSteps;
        this.sequence = sequence;
        this.solution = solution;
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

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public List<Integer> getSolutionSteps() {
        return solutionSteps;
    }

    public void setSolutionSteps(List<Integer> solutionSteps) {
        this.solutionSteps = solutionSteps;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

}

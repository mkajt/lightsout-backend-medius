package com.medius.lightsout.entity;

import jakarta.persistence.*;

@Entity(name="solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solutionId")
    private Integer solutionId;

    @ManyToOne()
    @JoinColumn(name = "problemId", referencedColumnName = "problemId")
    private Problem problem;

    public Solution() {
    }

    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}

package com.medius.lightsout.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity(name="solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solutionId")
    private Integer solutionId;

    @ManyToOne()
    @JoinColumn(name = "problemId", referencedColumnName = "problemId")
    private Problem problem;

    @OneToMany(mappedBy = "solution", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Solution_step> solutionSteps;

    public Solution() {
    }

    public Solution(Problem problem) {
        this.problem = problem;
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

    public List<Solution_step> getSolutionSteps() {
        return solutionSteps;
    }

    public void setSolutionSteps(List<Solution_step> solutionSteps) {
        this.solutionSteps = solutionSteps;
    }
}

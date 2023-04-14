package com.medius.lightsout.service;

import com.medius.lightsout.entity.Solution;
import com.medius.lightsout.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SolutionService {

    @Autowired
    SolutionRepository solutionRepository;

    public ArrayList<Solution> getAllSolutions() {
        return (ArrayList<Solution>) solutionRepository.findAll();
    }

    public ArrayList<Solution> getSolutionsForSelectedProblem(Integer problemId) {
        Optional<ArrayList<Solution>> selected = solutionRepository.findByProblemProblemId(problemId);
        return selected.orElse(null);
    }
}

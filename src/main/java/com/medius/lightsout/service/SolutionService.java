package com.medius.lightsout.service;

import com.medius.lightsout.entity.Solution;
import com.medius.lightsout.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolutionService {

    @Autowired
    SolutionRepository solutionRepository;

    public List<Solution> getAllSolutions() {
        return (List<Solution>) solutionRepository.findAll();
    }

    public List<Solution> getSolutionsForSelectedProblem(Integer problemId) {
        Optional<List<Solution>> selected = solutionRepository.findByProblemProblemId(problemId);
        return selected.orElse(null);
    }
}

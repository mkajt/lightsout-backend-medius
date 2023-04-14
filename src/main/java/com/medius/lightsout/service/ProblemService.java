package com.medius.lightsout.service;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//business logic
@Service
public class ProblemService {

    @Autowired
    ProblemRepository problemRepository;

    public List<Problem> getAllProblems() {
        return (List<Problem>) problemRepository.findAll();
    }

    public Problem getSelectedProblem(Integer problemId) {
        Optional<Problem> selected = problemRepository.findById(problemId);
        /*
        if (selected.isPresent()) {
            return selected.get();
        }
        */
        return selected.orElse(null);
    }

    public String addProblem(Problem problem) {
        problemRepository.save(problem);
        return "Successfully added problem.";
    }


}

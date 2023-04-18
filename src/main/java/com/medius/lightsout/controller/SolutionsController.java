package com.medius.lightsout.controller;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.entity.Solution;
import com.medius.lightsout.service.ProblemService;
import com.medius.lightsout.service.SolutionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//swagger: http://localhost:8080/openapi/swagger-ui/index.html#/
@RestController
@RequestMapping(value = "/solutions")
@Tag(name = "Solutions Controller")
public class SolutionsController {

    @Autowired
    SolutionService solutionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Solution> getAllSolutions() {
        return solutionService.getAllSolutions();
    }

    @GetMapping(value = "/problem/{problemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Solution> getSolutionsForSelectedProblem(@PathVariable("problemId") Integer problemId) {
        return solutionService.getSolutionsForSelectedProblem(problemId);
    }
}

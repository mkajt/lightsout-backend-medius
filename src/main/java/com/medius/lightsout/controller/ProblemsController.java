package com.medius.lightsout.controller;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.service.ProblemService;
import com.medius.lightsout.solver.Solver;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//swagger: http://localhost:8080/openapi/swagger-ui/index.html#/
@RestController
@RequestMapping(value = "/problems")
@Tag(name = "Problems Controller")
public class ProblemsController {

    @Autowired
    ProblemService problemService;

    @Autowired
    Solver solver;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Problem> getAllProblems() {
        List<Problem> all =  problemService.getAllProblems();
        return all;
    }

    @GetMapping(value = "/{problemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Problem getSelectedProblem(@PathVariable("problemId") Integer problemId) {
        return problemService.getSelectedProblem(problemId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer add(@RequestBody Problem problem) {
        return solver.solver2(problem);
    }

}

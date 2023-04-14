package com.medius.lightsout.controller;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.service.ProblemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//swagger: http://localhost:8080/openapi/swagger-ui/index.html#/
//za dokumentacijo API-ja: https://stackoverflow.com/questions/75323201/how-can-i-control-tag-name-on-api-in-openapi-spring-generator
@RestController
@RequestMapping(value = "/problems")
@Tag(name = "Problems Controller")
public class ProblemsController {

    @Autowired
    ProblemService problemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Problem> getAllProblems() {
        return problemService.getAllProblems();
    }

    @GetMapping(value = "/{problemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Problem getSelectedProblem(@PathVariable("problemId") Integer problemId) {
        return problemService.getSelectedProblem(problemId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody Problem problem) {
        return problemService.addProblem(problem);
    }

}

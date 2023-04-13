package com.medius.lightsout.controller;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.service.LightsoutService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

//swagger: http://localhost:8080/openapi/swagger-ui/index.html#/
//za dokumentacijo API-ja: https://stackoverflow.com/questions/75323201/how-can-i-control-tag-name-on-api-in-openapi-spring-generator
@RestController
@RequestMapping(value = "/problems")
@Tag(name = "Problems Controller")
public class ProblemsController {

    @Autowired
    LightsoutService lightsoutService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<Problem> getAllProblems() {
        return lightsoutService.getAllProblems();
    }

    @GetMapping(value = "/{problemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Problem getSelectedProblem(@PathVariable("problemId") int problemId) {
        return lightsoutService.getSelectedProblem(problemId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody Problem problem) {
        return lightsoutService.add(problem);
    }

}

package com.medius.lightsout.controller;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.service.LightsoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    LightsoutService lightsoutService;

    @GetMapping(value = "problems", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Problem> getAll() {
        return lightsoutService.getAll();
    }

    @PostMapping(value = "problems", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody Problem problem) {
        return lightsoutService.add(problem);
    }

}

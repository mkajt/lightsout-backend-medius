package com.medius.lightsout.repository;

import org.springframework.stereotype.Repository;
import com.medius.lightsout.entity.Problem;

import java.util.ArrayList;

@Repository
public class LightsoutRepository {

    public ArrayList<Problem> problems = new ArrayList<Problem>();
    public ArrayList<Problem> getAll() {
        return problems;
    }

    public String add(Problem problem) {
        problems.add(problem);
        return "Successfully added problem.";
    }
}
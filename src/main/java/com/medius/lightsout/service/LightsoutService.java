package com.medius.lightsout.service;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.repository.LightsoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LightsoutService {

    @Autowired
    LightsoutRepository lightsoutRepository;
    public ArrayList<Problem> getAll() {
        return lightsoutRepository.getAll();
    }

    public String add(Problem problem) {
        return lightsoutRepository.add(problem);
    }
}
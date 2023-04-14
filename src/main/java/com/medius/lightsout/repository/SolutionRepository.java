package com.medius.lightsout.repository;

import com.medius.lightsout.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {
    Optional<ArrayList<Solution>> findByProblemProblemId(Integer problemId);
}

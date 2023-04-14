package com.medius.lightsout.repository;

import com.medius.lightsout.entity.Solution;
import com.medius.lightsout.entity.Solution_step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionStepRepository extends JpaRepository<Solution_step, Integer> {
}

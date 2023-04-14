package com.medius.lightsout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medius.lightsout.entity.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {
}

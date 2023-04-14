package com.medius.lightsout;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.entity.Solution;
import com.medius.lightsout.entity.Solution_step;
import com.medius.lightsout.repository.ProblemRepository;
import com.medius.lightsout.repository.SolutionRepository;
import com.medius.lightsout.repository.SolutionStepRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class LightsoutApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(LightsoutApplication.class, args);

		ProblemRepository problemRepository = configurableApplicationContext.getBean(ProblemRepository.class);
		List<Integer> numbers = new ArrayList<>();
		numbers.add(0);
		numbers.add(0);
		numbers.add(1);
		numbers.add(0);
		numbers.add(1);
		numbers.add(0);
		numbers.add(0);
		numbers.add(0);
		numbers.add(1);
		Problem problem1 = new Problem(numbers, 3);
		problemRepository.save(problem1);

		SolutionRepository solutionRepository = configurableApplicationContext.getBean(SolutionRepository.class);
		Solution solution1 = new Solution();
		solution1.setProblem(problem1);
		solutionRepository.save(solution1);

		SolutionStepRepository solutionStepRepository = configurableApplicationContext.getBean(SolutionStepRepository.class);
		List<Integer> steps = new ArrayList<>();
		steps.add(0);
		steps.add(0);
		steps.add(1);
		steps.add(0);
		steps.add(1);
		steps.add(0);
		steps.add(0);
		steps.add(0);
		steps.add(1);
		Solution_step solutionStep1 = new Solution_step(steps, 1);
		solutionStep1.setSolution(solution1);
		solutionStepRepository.save(solutionStep1);



	}

}

package com.medius.lightsout;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.entity.Solution;
import com.medius.lightsout.entity.Solution_step;
import com.medius.lightsout.repository.ProblemRepository;
import com.medius.lightsout.repository.SolutionRepository;
import com.medius.lightsout.repository.SolutionStepRepository;
import com.medius.lightsout.solver.CombinationGenerator;
import com.medius.lightsout.solver.Solver;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Arrays;
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

		Solver solverClass = new Solver();
		List<Integer> elements = new ArrayList<>();
		elements.add(0);
		elements.add(1);
		elements.add(2);
		elements.add(3);
		elements.add(4);
		//List<List<Integer>> combinations = solverClass.solver(elements);
		//System.out.println(combinations.toString());

		/*int[] nums = {1, 2, 3};
		int k = 2;
		CombinationGenerator.generateCombinations(nums, new int[k], 0, 0);*/


		/*List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<List<Integer>> solution = Solver.generateCombinations(list);
		System.out.println(solution.toString());*/

		List<Integer> matrix1 = Arrays.asList(1,1,1,0,1,1,0,0,1);
		Solver.solver(matrix1, 3);

		List<Integer> matrix2 = Arrays.asList(1,0,1,0,0,1,0,1,1);
		Solver.solver(matrix2, 3);

		List<Integer> matrix3 = Arrays.asList(1,0,0,0,0,0,1,0,1,1,0,0,1,1,0,1);
		Solver.solver(matrix3, 4);

		List<Integer> matrix4 = Arrays.asList(0,1,1,0,1,1,1,1,0,1,1,0,1,0,0,1);
		Solver.solver(matrix4, 4);

		List<Integer> matrix5 = Arrays.asList(1,1,0,1,1,0,1,1,1,0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,1);
		Solver.solver(matrix5, 5);
		/*List<Integer> list = Arrays.asList(1, 2, 3);
		CombinationGenerator.generateCombinations(list);*/
	}

}

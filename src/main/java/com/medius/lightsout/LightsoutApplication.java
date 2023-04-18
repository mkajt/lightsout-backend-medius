package com.medius.lightsout;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.entity.Solution;
import com.medius.lightsout.entity.Solution_step;
import com.medius.lightsout.repository.ProblemRepository;
import com.medius.lightsout.repository.SolutionRepository;
import com.medius.lightsout.repository.SolutionStepRepository;
import com.medius.lightsout.service.ProblemService;
import com.medius.lightsout.service.SolutionService;
import com.medius.lightsout.solver.Solver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class LightsoutApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(LightsoutApplication.class, args);

		ProblemService problemService = configurableApplicationContext.getBean(ProblemService.class);
		SolutionService solutionService = configurableApplicationContext.getBean(SolutionService.class);

		Solver solverService = new Solver(problemService, solutionService);
		List<Integer> matrix6 = Arrays.asList(0,0,1,0,1,0,0,0,1);
		solverService.solver(matrix6, 3);

		List<Integer> matrix1 = Arrays.asList(1,1,1,0,1,1,0,0,1);
		solverService.solver(matrix1, 3);

		List<Integer> matrix2 = Arrays.asList(1,0,1,0,0,1,0,1,1);
		solverService.solver(matrix2, 3);

		List<Integer> matrix3 = Arrays.asList(1,0,0,0,0,0,1,0,1,1,0,0,1,1,0,1);
		solverService.solver(matrix3, 4);

		List<Integer> matrix4 = Arrays.asList(0,1,1,0,1,1,1,1,0,1,1,0,1,0,0,1);
		solverService.solver(matrix4, 4);

		List<Integer> matrix5 = Arrays.asList(1,1,0,1,1,0,1,1,1,0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,1);
		solverService.solver(matrix5, 5);
		/*List<Integer> list = Arrays.asList(1, 2, 3);
		CombinationGenerator.generateCombinations(list);*/
	}

}

package com.medius.lightsout.solver;

import com.medius.lightsout.entity.Problem;
import com.medius.lightsout.entity.Solution;
import com.medius.lightsout.entity.Solution_step;
import com.medius.lightsout.service.ProblemService;
import com.medius.lightsout.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class Solver {

    private Problem problem;
    private Integer numberOfMoves;

    private final ProblemService problemService;
    private final SolutionService solutionService;

    public Solver(ProblemService problemService, SolutionService solutionService) {
        this.problemService = problemService;
        this.solutionService = solutionService;
    }

    public String solver(List<Integer> matrix, Integer matrixSize) {

        problem = new Problem();
        problem.setMatrix(matrix);
        problem.setMatrixSize(matrixSize);
        numberOfMoves = 0;

        long startTime = System.nanoTime();

        List<Integer> fields = IntStream.rangeClosed(0, matrixSize-1).boxed().toList();
        List<Integer> solution_step = solveMatrix(fields);

        long endTime = System.nanoTime();
        double differenceTime = (endTime - startTime)/ 1e6;
        System.out.println("\nTime duration: " + differenceTime + "ms");

        if (solution_step != null) {
            System.out.println("Solution step: " + solution_step);
            System.out.println("Number of moves: " + numberOfMoves);

            problemService.addProblem(problem);
            Solution solution = new Solution(problem);
            Solution_step sStep = new Solution_step(solution_step,1,solution);
            List<Solution_step> solutionSteps = Arrays.asList(sStep);
            solution.setSolutionSteps(solutionSteps);
            solutionService.addSolution(solution);

            return "Solvable problem.";
        }
        System.out.println("Unsolvable problem.");
        return "Unsolvable problem.";
    }

    public Integer solver2(Problem problem2) {

        problem = new Problem();
        problem.setMatrix(problem2.getMatrix());
        problem.setMatrixSize(problem2.getMatrixSize());
        numberOfMoves = 0;

        long startTime = System.nanoTime();

        List<Integer> fields = IntStream.rangeClosed(0, problem.getMatrixSize()-1).boxed().toList();
        List<Integer> solution_step = solveMatrix(fields);

        long endTime = System.nanoTime();
        double differenceTime = (endTime - startTime)/ 1e6;
        System.out.println("\nTime duration: " + differenceTime + "ms");

        if (solution_step != null) {
            System.out.println("Solution step: " + solution_step);
            System.out.println("Number of moves: " + numberOfMoves);

            Integer newProblemId = problemService.addProblem(problem);
            Solution solution = new Solution(problem);
            Solution_step sStep = new Solution_step(solution_step,1,solution);
            List<Solution_step> solutionSteps = Arrays.asList(sStep);
            solution.setSolutionSteps(solutionSteps);
            solutionService.addSolution(solution);

            return newProblemId;
        }
        System.out.println("Unsolvable problem.");
        return -1;
    }

    private List<Integer> solveMatrix(List<Integer> numbers) {
        ifLightsOut(problem.getMatrix());
        //List<Integer> matrix = new ArrayList<>(problem.getMatrix());

        Integer[] fields = numbers.toArray(new Integer[numbers.size()]);
        // Create a buffer to hold the current combination being generated
        List<Integer> buffer = new ArrayList<Integer>();

        // Generate combinations for each possible length, from 0 to the length of the input fields
        for (int i = 0; i <= fields.length; i++) {
            List<Integer> solution_step = generateCombinations(problem.getMatrix(), fields, buffer, 0, i);

            if (solution_step != null) {
                return solution_step;
            }
        }
        return null;
    }

    private List<Integer> generateCombinations(List<Integer> matrix, Integer[] fields, List<Integer> buffer, int startIndex, int length) {
        List<Integer> result;

        // If we have generated a combination of the desired length, print it out
        if (length == 0) {
            result = calculateMatrix(matrix, buffer);
            //printCombination(result);
            return result;
        }
        // Generate combinations by recursively selecting each element in turn, starting from the startIndex
        // and with the desired length decreasing by 1 at each step
        for (int i = startIndex; i <= fields.length - length; i++) {
            buffer.add(fields[i]);
            result = generateCombinations(matrix, fields, buffer, i + 1, length - 1);
            if (result != null) {
                return result;
            }
            buffer.remove(buffer.size() - 1);
        }

        return null;
    }

    private void printCombination(List<Integer> buffer) {
        for (int i = 0; i < buffer.size(); i++) {
            System.out.print(buffer.get(i) + " ");
        }
        System.out.println();
    }

    private List<Integer> calculateMatrix(List<Integer> oldMatrix, List<Integer> buffer) {

        numberOfMoves += 1;
        List<Integer> matrix = new ArrayList<>(oldMatrix);
        List<Integer> solution_step = new ArrayList<>();
        for (int i = 0; i < Math.pow(problem.getMatrixSize(), 2); i++) {
            solution_step.add(0);
        }

        // Change first row of a matrix according to buffer
        for (int i = 0; i < buffer.size(); i++) {
            Integer toggleIndex = buffer.get(i);
            matrix = toggleField(matrix, toggleIndex);
            solution_step.set(toggleIndex, 1);
        }

        matrix = toggleBellowFields(matrix, solution_step);

        if (ifLightsOut(matrix)) {
            return solution_step;
        } else {
            return null;
        }

    }

    private List<Integer> toggleBellowFields(List<Integer> matrix, List<Integer> solution_step) {
        for (int i = problem.getMatrixSize(); i < Math.pow(problem.getMatrixSize(),2); i++) {
            if (matrix.get(i - problem.getMatrixSize()) == 1) {
                matrix = toggleField(matrix, i);
                solution_step.set(i, 1);
            }
        }
        return matrix;
    }

    private List<Integer> toggleField(List<Integer> matrix, Integer field) {
        // set clicked field
        if (matrix.get(field) == 1) {
            matrix.set(field, 0);
        } else {
            matrix.set(field, 1);
        }

        // set left field & if it is not on the border
        if (field % problem.getMatrixSize() != 0) {
            if (matrix.get(field-1) == 1) {
                matrix.set(field-1, 0);
            } else {
                matrix.set(field-1, 1);
            }
        }

        // set right field & if it is not on the border
        if ((field+1) % problem.getMatrixSize() != 0) {
            if (matrix.get(field+1) == 1) {
                matrix.set(field+1, 0);
            } else {
                matrix.set(field+1, 1);
            }
        }

        // set top field & if it is not on the top
        if (field - problem.getMatrixSize() >= 0) {
            if (matrix.get(field-problem.getMatrixSize()) == 1) {
                matrix.set(field-problem.getMatrixSize(), 0);
            } else {
                matrix.set(field-problem.getMatrixSize(), 1);
            }
        }

        // set bottom field & if it is not on the bottom
        if (field + problem.getMatrixSize() < Math.pow(problem.getMatrixSize(),2)) {
            if (matrix.get(field+problem.getMatrixSize()) == 1) {
                matrix.set(field+problem.getMatrixSize(), 0);
            } else {
                matrix.set(field+problem.getMatrixSize(), 1);
            }
        }

        return matrix;
    }

    private boolean ifLightsOut(List<Integer> matrix) {
        return !matrix.contains(1);
    }

}

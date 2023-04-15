package com.medius.lightsout.solver;

import com.medius.lightsout.entity.Problem;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Solver {

    private static Problem problem;
    private static Integer numberOfMoves;

    public static String solver(List<Integer> matrix, Integer matrixSize) {
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
            return "Solvable problem.";
        }
        System.out.println("Unsolvable problem.");
        return "Unsolvable problem.";
    }

    private static List<Integer> solveMatrix(List<Integer> numbers) {
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

    private static List<Integer> generateCombinations(List<Integer> matrix, Integer[] fields, List<Integer> buffer, int startIndex, int length) {
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

    private static void printCombination(List<Integer> buffer) {
        for (int i = 0; i < buffer.size(); i++) {
            System.out.print(buffer.get(i) + " ");
        }
        System.out.println();
    }

    private static List<Integer> calculateMatrix(List<Integer> oldMatrix, List<Integer> buffer) {

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

    private static List<Integer> toggleBellowFields(List<Integer> matrix, List<Integer> solution_step) {
        for (int i = problem.getMatrixSize(); i < Math.pow(problem.getMatrixSize(),2); i++) {
            if (matrix.get(i - problem.getMatrixSize()) == 1) {
                matrix = toggleField(matrix, i);
                solution_step.set(i, 1);
            }
        }
        return matrix;
    }

    private static List<Integer> toggleField(List<Integer> matrix, Integer field) {
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

    private static boolean ifLightsOut(List<Integer> matrix) {
        return !matrix.contains(1);
    }

}

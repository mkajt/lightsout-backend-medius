package com.medius.lightsout.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationGenerator {

    /*
    nums: the int array to generate combinations from
    combination: an array to store the current combination
    start: the starting index of the nums array to consider for the current combination
    index: the current index of the combination array to fill


    public static void generateCombinations(int[] nums, int[] combination, int start, int index) {
        if (index == combination.length) {
            System.out.println(Arrays.toString(combination));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            combination[index] = nums[i];
            generateCombinations(nums, combination, i + 1, index + 1);
        }
    }*/

    public static void generateCombinations(List<Integer> list) {
        // Convert the list to an array to make it easier to work with
        Integer[] arr = list.toArray(new Integer[list.size()]);
        // Create a buffer to hold the current combination being generated
        List<Integer> buffer = new ArrayList<Integer>();
        // Generate combinations for each possible length, from 0 to the length of the input array
        for (int i = 0; i <= arr.length; i++) {
            generateCombinationsHelper(arr, buffer, 0, i);
        }
    }

    private static void generateCombinationsHelper(Integer[] arr, List<Integer> buffer, int startIndex, int length) {
        // If we have generated a combination of the desired length, print it out
        if (length == 0) {

            printCombination(buffer);
            return;
        }
        // Generate combinations by recursively selecting each element in turn, starting from the startIndex
        // and with the desired length decreasing by 1 at each step
        for (int i = startIndex; i <= arr.length - length; i++) {
            buffer.add(arr[i]);
            generateCombinationsHelper(arr, buffer, i + 1, length - 1);
            buffer.remove(buffer.size() - 1);
        }
    }

    private static void printCombination(List<Integer> buffer) {
        for (int i = 0; i < buffer.size(); i++) {
            System.out.print(buffer.get(i) + " ");
        }
        System.out.println();
    }
}


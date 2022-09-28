package com.rarestzhou.codewars.september;

import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/24 11:38 PM
 * @description: Given an array of integers.
 * <p>
 * Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers. 0 is neither positive nor negative.
 * <p>
 * If the input is an empty array or is null, return an empty array.
 */
public class CountPositivesSumNegatives {

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }
        return solutionLoop(input);
    }

    public static int[] solutionLoop(int[] input) {
        int countOfPositives = 0;
        int sumOfNegative = 0;
        for (int i : input) {
            if (i == 0) {
                continue;
            }
            if (i < 0) {
                sumOfNegative += i;
            } else {
                countOfPositives += 1;
            }
        }
        return new int[]{countOfPositives, sumOfNegative};
    }

    public static int[] solutionStream(int[] input) {
        int sumOfNegative = IntStream.of(input).filter(num -> num < 0).sum();
        long countOfPositives = IntStream.of(input).filter(num -> num > 0).count();
        return new int[]{(int) countOfPositives, sumOfNegative};
    }
}

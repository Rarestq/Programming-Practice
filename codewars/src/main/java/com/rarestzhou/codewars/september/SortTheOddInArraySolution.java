package com.rarestzhou.codewars.september;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/28 10:27 PM
 * @description: https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/train/java
 * <p>
 * Task:
 * You will be given an array of numbers. You have to sort the odd numbers in ascending order
 * while leaving the even numbers at their original positions.
 * <p>
 * Examples:
 * [7, 1]  =>  [1, 7]
 * [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
 * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */
public class SortTheOddInArraySolution {

    public static int[] sortArray(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                continue;
            }
            for (int j = i; j < array.length; j++) {
                if (array[j] % 2 == 0) {
                    continue;
                }
                // change the order
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static int[] sortArrayCleverSolution(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        // Sort the odd numbers only
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        // Then merge them back into original array
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) {
                array[j] = sortedOdd[s++];
            }
        }

        return array;
    }

    public static void main(String[] args) {
        Arrays.stream(sortArrayCleverSolution(new int[]{5, 3, 1, 8, 0})).forEach(System.out::println);
//        Arrays.stream(sortArray(new int[]{})).forEach(System.out::println);
    }
}

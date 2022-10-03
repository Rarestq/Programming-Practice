package com.rarestzhou.codewars.september;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/25 2:23 PM
 * @description: https://www.codewars.com/kata/523f5d21c841566fde000009/train/java
 */
public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        if (b == null || b.length == 0) {
            return a;
        }
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            diffMap.put(i, b[i]);
        }
        return IntStream.of(a).filter(num -> !diffMap.containsValue(num)).toArray();
    }

    public static int[] arrayDiffSolution2(int[] a, int[] b) {
        if (b == null || b.length == 0) {
            return a;
        }
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        int[] ints = arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2});
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        System.out.println("===");
        int[] ints1 = arrayDiffSolution2(new int[]{1, 2, 2, 2, 3}, new int[]{2});
        for (int anInt : ints1) {
            System.out.println(anInt);
        }
    }
}

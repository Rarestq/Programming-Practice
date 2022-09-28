package com.rarestzhou.codewars.september;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/28 4:05 PM
 * @description: https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/java
 * <p>
 * Given a list and a number, create a new list that contains each number of list at most N times,
 * without reordering.
 * For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
 * drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3,
 * which leads to [1,2,3,1,2,3].
 * With list [20,37,20,21] and number 1, the result would be [20,37,21].
 */
public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        //Code here ;)

        // edge cases
        if (elements == null || elements.length == 0 || maxOccurrences == 0) {
            return new int[]{};
        }
        if (maxOccurrences == 1) {
            return Arrays.stream(elements).distinct().toArray();
        }
        // define a HashMap to record the occurrence of element
        Map<Integer, Integer> elementOccurrenceMap = new HashMap<>();
        // define a LinkedList to assure the order of elements
        LinkedList<Integer> result = new LinkedList<>();
        for (int element : elements) {
            if (elementOccurrenceMap.containsKey(element)) {
                Integer occurrence = elementOccurrenceMap.get(element);
                if (occurrence < maxOccurrences) {
                    elementOccurrenceMap.put(element, occurrence + 1);
                    result.addLast(element);
                    continue;
                }

                if (occurrence > maxOccurrences) {
                    result.removeLastOccurrence(element);
                }
                continue;
            }
            // initialize the occurrence of element
            elementOccurrenceMap.put(element, 1);
            result.addLast(element);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] deleteNthBestPracticeSolution(int[] elements, int maxOccurrences) {
        if (maxOccurrences < 1) {
            return new int[0];
        }

        final HashMap<Integer, Integer> map = new HashMap<>();
        final List<Integer> list = new ArrayList<>();

        for (final Integer i : elements) {
            final Integer v = map.put(i, map.getOrDefault(i, 0) + 1);
            if (v == null || v < maxOccurrences) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] deleteNthCleverSolution(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        return IntStream.of(elements)
                .filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
                .toArray();
    }

    public static void main(String[] args) {
        int[] deleteNth = deleteNthBestPracticeSolution(new int[]{20, 37, 20, 21}, 1);
        // expected:20, 37, 21, actual:20, 37, 21
        System.out.println(Arrays.stream(deleteNth).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

        System.out.println("==");

        int[] deleteNth1 = deleteNth(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3);
        // expected:1, 1, 3, 3, 7, 2, 2, 2, actual:1, 1, 3, 3, 7, 2, 2, 2
        System.out.println(Arrays.stream(deleteNth1).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

        System.out.println("==");
        int[] deleteNth2 = deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5,
                3, 1}, 3);
        // expected:1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5, actual:1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5
        System.out.println(Arrays.stream(deleteNth2).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

        System.out.println("==");
        int[] deleteNth3 = deleteNth(new int[]{1, 1, 1, 1, 1}, 5);
        // expected:1, 1, 1, 1, 1, actual:1, 1, 1, 1, 1
        System.out.println(Arrays.stream(deleteNth3).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

        System.out.println("==");
        int[] deleteNth4 = deleteNth(new int[]{}, 5);
        // expected:{}, actual:{}
        System.out.println(Arrays.stream(deleteNth4).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

        System.out.println("==");
        int[] deleteNth5 = deleteNth(new int[]{1, 2, 1, 3, 2, 4, 2, 4}, 2);
        // expected:{}, actual:{}
        System.out.println(Arrays.stream(deleteNth5).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

        System.out.println("==");
        int[] deleteNth6 = deleteNth(new int[]{1, 2, 1, 3}, 1);
        // expected:{}, actual:{}
        System.out.println(Arrays.stream(deleteNth6).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
    }
}

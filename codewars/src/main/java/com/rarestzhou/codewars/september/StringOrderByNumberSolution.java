package com.rarestzhou.codewars.september;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/29 9:59 PM
 * @description: https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java
 * <p>
 * Your task is to sort a given string. Each word in the string will contain a single number.
 * This number is the position the word should have in the result.
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * <p>
 * If the input string is empty, return an empty string. The words in the input String will only
 * contain valid consecutive numbers.
 * <p>
 * Examples
 * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
 * ""  -->  ""
 */
public class StringOrderByNumberSolution {

    public static String order(String words) {
        if (words == null || words.length() == 0) {
            return "";
        }

        String[] arr = words.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (String s : arr) {
                if (s.contains(String.valueOf(i))) {
                    result.append(s).append(" ");
                }
            }
        }
        return result.toString().trim();
    }

    public static String orderCleverVersion(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(a -> a.replaceAll("\\D+", "")))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(orderCleverVersion("is2 Thi1s T4est 3a"));
        System.out.println(orderCleverVersion("is2 Thi1s T4est 3a").equals("Thi1s is2 3a T4est"));

        System.out.println(orderCleverVersion("4of Fo1r pe6ople g3ood th5e the2"));
        System.out.println(orderCleverVersion("4of Fo1r pe6ople g3ood th5e the2")
                .equals("Fo1r the2 g3ood 4of th5e pe6ople"));

        System.out.println(orderCleverVersion("").equals(""));
    }
}

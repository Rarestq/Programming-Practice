package com.rarestzhou.codewars.september;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/27 11:17 PM
 * @description: https://www.codewars.com/kata/5592e3bd57b64d00f3000047/train/java
 * <p>
 * You are given the total volume m of the building. Being given m can you find the number n of
 * cubes you will have to build?
 * <p>
 * The parameter of the function findNb (find_nb, find-nb, findNb, ...) will be an integer m and
 * you have to return the integer n such as n^3 + (n-1)^3 + ... + 1^3 = m if such a n exists or -1
 * if there is no such n.
 * <p>
 * Examples:
 * findNb(1071225) --> 45
 * <p>
 * findNb(91716553919377) --> -1
 */
public class ASum {

    public static long findNb(long m) {
        // your code
        if (m == 0L) {
            return -1L;
        }
        if (m == 1L) {
            return m;
        }
        long total = 0;
        int counter = 0;

        while (total < m) {
            counter++;
            total = total + (long) Math.pow(counter, 3);
        }

        return m == total ? counter : -1;
    }

    public static long findNbClever(long m) {
        long mm = 0, n = 0;
        while (mm < m) {
            mm += ++n * n * n;
        }
        return mm == m ? n : -1;
    }
}

package com.rarestzhou.codewars.september;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/30 10:42 PM
 * @description: https://www.codewars.com/kata/55e2adece53b4cdcb900006c/train/java
 * <p>
 * Two tortoises named A and B must run a race. A starts with an average speed of 720 feet per hour.
 * Young B knows she runs faster than A, and furthermore has not finished her cabbage.
 * <p>
 * When she starts, at last, she can see that A has a 70 feet lead but B's speed is 850 feet per hour.
 * How long will it take B to catch A?
 * <p>
 * More generally: given two speeds v1 (A's speed, integer > 0) and v2 (B's speed, integer > 0)
 * and a lead g (integer > 0) how long will it take B to catch A?
 * <p>
 * The result will be an array [hour, min, sec] which is the time needed in hours, minutes and seconds
 * (round down to the nearest second) or a string in some languages.
 * <p>
 * If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++, C, Go, Nim, Pascal, COBOL,
 * Erlang, [-1, -1, -1] for Perl,[] for Kotlin or "-1 -1 -1".
 * <p>
 * Examples:
 * (form of the result depends on the language)
 * <p>
 * race(720, 850, 70) => [0, 32, 18] or "0 32 18"
 * race(80, 91, 37)   => [3, 21, 49] or "3 21 49"
 * Note:
 * See other examples in "Your test cases".
 * <p>
 * In Fortran - as in any other language - the returned string is not permitted to contain any redundant
 * trailing whitespace: you can use dynamically allocated character strings.
 * <p>
 * ** Hints for people who don't know how to convert to hours, minutes, seconds:
 * <p>
 * Tortoises don't care about fractions of seconds
 * Think of calculation by hand using only integers (in your code use or simulate integer division)
 * or Google: "convert decimal time to hours minutes seconds"
 */
public class TortoiseRacingSolution {

    public static int[] race(int v1, int v2, int g) {
        // your code
        if (v1 > v2) {
            return null;
        }

        int d = v2 - v1;
        return new int[]{g / d, ((g * 60) / d) % 60, ((g * 60 * 60) / d) % 60};
    }

    public static int[] raceBestPractice(int v1, int v2, int g) {
        int totalSecondsTaken = 0;
        if (v2 > v1) {
            totalSecondsTaken = (g * 3600) / (v2 - v1);
        } else {
            return null;
        }
        return new int[]{totalSecondsTaken / 3600, (totalSecondsTaken % 3600) / 60,
                totalSecondsTaken % 60};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(race(720, 850, 70), new int[]{0, 32, 18}));
        System.out.println(Arrays.equals(race(80, 91, 37), new int[]{3, 21, 49}));
        System.out.println(Arrays.equals(race(80, 100, 40), new int[]{2, 0, 0}));
    }
}

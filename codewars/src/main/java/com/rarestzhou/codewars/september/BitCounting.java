package com.rarestzhou.codewars.september;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/28 2:59 PM
 * @description: https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java
 * <p>
 * Write a function that takes an integer as input, and returns the number of bits that are equal to
 * one in the binary representation of that number. You can guarantee that input is non-negative.
 * <p>
 * Example: The binary representation of 1234 is 10011010010, so the function should return 5
 * in this case
 */
public class BitCounting {

    public static int countBits(int n) {
        // Show me the code!
        if (n == 0) {
            return 0;
        }
        return (int) Integer.toBinaryString(n).chars()
                .filter(c -> c == '1')
                .count();
    }

    public static int countBitsEasy(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(countBits(1234));
        System.out.println(countBitsEasy(1234));
    }
}

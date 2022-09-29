package com.rarestzhou.codewars.september;

import java.util.regex.Pattern;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/28 9:39 PM
 * @description: https://www.codewars.com/kata/55f8a9c06c018a0d6e000132/train/java
 *
 * ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits
 * or exactly 6 digits.
 *
 * If the function is passed a valid PIN string, return true, else return false.
 *
 * Examples (Input --> Output)
 * "1234"   -->  true
 * "12345"  -->  false
 * "a234"   -->  false
 */
public class RegexValidatePINCodeSolution {

    public static boolean validatePin(String pin) {
        // Your code here...
        String regex = "(\\d{4}$)|(\\d{6}$)";
        return Pattern.matches(regex, pin);
    }

    public static void main(String[] args) {
        System.out.println(validatePin("1234"));
        System.out.println(validatePin("12345"));
        System.out.println(validatePin("a234"));
        System.out.println(validatePin("123456"));
        System.out.println(validatePin("a23456"));
        System.out.println(validatePin("1234567"));
    }
}

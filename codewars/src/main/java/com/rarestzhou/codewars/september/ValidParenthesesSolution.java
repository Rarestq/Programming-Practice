package com.rarestzhou.codewars.september;

import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/29 8:34 PM
 * @description: https://www.codewars.com/kata/52774a314c2333f0a7000688/train/java
 * <p>
 * Write a function that takes a string of parentheses, and determines if the order of the parentheses
 * is valid. The function should return true if the string is valid, and false if it's invalid.
 * <p>
 * Examples
 * "()"              =>  true
 * ")(()))"          =>  false
 * "("               =>  false
 * "(())((()())())"  =>  true
 * <p>
 * Constraints
 * 0 <= input.length <= 100
 * <p>
 * Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters.
 * Furthermore, the input string may be empty and/or not contain any parentheses at all. Do not treat
 * other forms of brackets as parentheses (e.g. [], {}, <>)
 */
public class ValidParenthesesSolution {

    private static final Character leftParentheses = '(';
    private static final Character rightParentheses = ')';

    public static boolean validParentheses(String parens) {
        //Put code below

        // param check
        if (parens == null || parens.length() == 0) {
            return true;
        }

        if (parens.startsWith(")")) {
            return false;
        }

        // define a stack to store parentheses
        Stack<Character> stack = new Stack<>();
        char[] chars = parens.toCharArray();
        for (char ch : chars) {
            // if ch is not a parentheses,then not pushing into stack
            if (ch != leftParentheses && ch != rightParentheses) {
                continue;
            }
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if (peek == leftParentheses && ch == rightParentheses) {
                    stack.pop();
                    continue;
                }
            }
            // push the parentheses into stack
            stack.push(ch);
        }

        return stack.isEmpty();
    }

    public static boolean validParenthesesV1(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != leftParentheses && c != rightParentheses) {
                continue;
            }
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static boolean validParenthesesCleverSolution(String parens) {
        try {
            Pattern.compile(parens.replaceAll("[^()]", ""));
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // expected:false, actual:false
        System.out.println(validParenthesesV1(")(()))"));

        // expected:true, actual:true
        System.out.println(validParenthesesV1("()"));

        // expected:false, actual:false
        System.out.println(validParenthesesV1("())"));

        // expected:true, actual:true
        System.out.println(validParenthesesV1("32423(sgsdg)"));

        // expected:false, actual:false
        System.out.println(validParenthesesV1("(dsgdsg))2432"));
        // expected:true, actual:true
        System.out.println(validParenthesesV1("adasdasfa"));
    }
}

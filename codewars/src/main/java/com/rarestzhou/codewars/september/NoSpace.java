package com.rarestzhou.codewars.september;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/24 11:51 PM
 * @description: remove the spaces from the string, then return the resultant string.
 */
public class NoSpace {

    public static String noSpace(final String x) {
        return x.replace(" ", "");
    }

    public static void main(String[] args) {
        System.out.println("8j8mBliB8gimjB8B8jlB"
                .equals(noSpace("8 j 8   mBliB8g  imjB8B8  jl  B")));
        System.out.println("88Bifk8hB8BB8BBBB888chl8BhBfd"
                .equals(noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd")));
        System.out.println("8aaaaaddddr"
                .equals(noSpace("8aaaaa dddd r     ")));
        System.out.println("jfBmgklf8hg88lbe8"
                .equals(noSpace("jfBm  gk lf8hg  88lbe8 ")));
        System.out.println("8jaam"
                .equals(noSpace("8j aam")));
    }
}

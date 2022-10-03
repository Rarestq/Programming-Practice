package com.rarestzhou.bookonjava.basic.strings;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 8:51 PM
 * @description: ${description}
 */
public class Immutable {

    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        // howdy
        System.out.println(q);

        String qq = upcase(q);
        // HOWDY
        System.out.println(qq);
        // howdy
        System.out.println(q);
    }
}

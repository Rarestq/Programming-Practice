package com.rarestzhou.bookonjava.basic.strings;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 9:10 PM
 * @description: ${description}
 */
public class UsingStringBuilder {

    public static String string1() {
        Random rand = new Random(47);
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static String string2() {
        String result = new Random(47)
                .ints(25, 0, 100)
                .mapToObj(Integer::toString)
                // 内部使用 StringBuilder 实现
                .collect(Collectors.joining(", "));
        return "[" + result + "]";
    }

    public static void main(String[] args) {
        // [58, 55, 93, 61, 61, 29, 68, 0, 22, 7, 88, 28, 51, 89, 9, 78, 98, 61, 20, 58, 16, 40, 11, 22, 4]
        System.out.println(string1());
        // [58, 55, 93, 61, 61, 29, 68, 0, 22, 7, 88, 28, 51, 89, 9, 78, 98, 61, 20, 58, 16, 40, 11, 22, 4]
        System.out.println(string2());
    }
}

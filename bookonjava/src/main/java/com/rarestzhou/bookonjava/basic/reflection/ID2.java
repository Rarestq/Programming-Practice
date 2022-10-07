package com.rarestzhou.bookonjava.basic.reflection;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/10/7 8:49 PM
 * @description: 这里 ID2 类是 public 的，所以不需要显式定义一个public的无参构造器
 */
public class ID2 {

    private static long counter;
    private final long id = counter++;

    @Override public String toString() {
        return Long.toString(id);
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(ID2.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }
}

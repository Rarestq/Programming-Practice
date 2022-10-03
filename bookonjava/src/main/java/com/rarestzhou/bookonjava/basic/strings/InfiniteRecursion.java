package com.rarestzhou.bookonjava.basic.strings;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 9:41 PM
 * @description: 意外的递归
 */

// {ThrowsException}
// {VisuallyInspectOutput} Throws very long exception
public class InfiniteRecursion {

    @Override
    public String toString() {
        // String 后面跟着一个 + 和一个不是 String 的东西（this），编译器会试图将 this 转换为一个 String
        // 该转换是通过 toString() 方法转换的，这样就形成了递归调用
        // 正确做法是直接调用 Object 的 toString 方法： super.toString():
//        return " InfiniteRecursion address: " + this + "\n";
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        Stream.generate(InfiniteRecursion::new)
                .limit(10)
                .forEach(System.out::println);
    }
}

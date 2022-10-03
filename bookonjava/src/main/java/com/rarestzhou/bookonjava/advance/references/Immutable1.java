package com.rarestzhou.bookonjava.advance.references;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 4:50 PM
 * @description: 不可变对象可以对引用别名的风险免疫
 */
public class Immutable1 {

    private int data;

    public Immutable1(int intVal) {
        data = intVal;
    }

    public int read() {
        return data;
    }

    public boolean nonzero() {
        return data != 0;
    }

    public Immutable1 multiply(int multiplier) {
        // 创建新的 Immutable1 对象，不影响原有对象
        return new Immutable1(data * multiplier);
    }

    public static void f(Immutable1 i1) {
        Immutable1 quad = i1.multiply(4);
        // i1 = 47
        System.out.println("i1 = " + i1.read());
        // quad = 188
        System.out.println("quad = " + quad.read());
    }

    public static void main(String[] args) {
        Immutable1 x = new Immutable1(47);
        // x=47
        System.out.println("x = " + x.read());
        f(x);
        // x = 47
        System.out.println("x = " + x.read());
    }
}

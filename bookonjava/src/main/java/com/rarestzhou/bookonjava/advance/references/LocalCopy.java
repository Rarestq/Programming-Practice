package com.rarestzhou.bookonjava.advance.references;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/13 4:56 PM
 * @description: ${description}
 */
public class LocalCopy {

    public static Duplo g(Duplo v) {
        // 传递引用，修改外部对象
        v.increment();
        return v;
    }

    public static Duplo f(Duplo v) {
        // 本地副本
        v = v.clone();
        v.increment();
        return v;
    }

    public static void main(String[] args) {
        Duplo a = new Duplo(11);
        Duplo b = g(a);
        // 引用相等，并不是对象相等
        System.out.println("a == b:" + (a == b) + "\na = " + a + "\nb= " + b);
        Duplo c = new Duplo(47);
        Duplo d = f(c);
        System.out.println("c == d:" + (c == d) + "\nc = " + c + "\nd= " + d);
    }
}

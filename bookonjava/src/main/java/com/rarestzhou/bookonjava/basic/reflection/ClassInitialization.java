package com.rarestzhou.bookonjava.basic.reflection;

import java.util.Random;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/10/7 8:21 PM
 * @description: 类初始化
 */
public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // 不会触发初始化
        System.out.println(Initable.STATIC_FINAL);
        System.out.println("===");
        // 触发初始化
        System.out.println(Initable.STATIC_FINAL2);
        // 触发初始化
        System.out.println(Initable2.staticNonFinal);
        // 全限定类名
        Class initable3 = Class.forName("com.rarestzhou.bookonjava.basic.reflection.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}


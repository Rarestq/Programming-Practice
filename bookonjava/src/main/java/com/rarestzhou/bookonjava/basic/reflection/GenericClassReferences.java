package com.rarestzhou.bookonjava.basic.reflection;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/10/7 8:37 PM
 * @description: 泛类型的引用
 */
public class GenericClassReferences {

    public static void main(String[] args) {
        Class integerClass = int.class;
        integerClass = double.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;

        // 不合法
        // genericIntClass = double.class;

        // 虽然Integer继承了Number，但是Integer的Class对象不是Number的Class对象的子类
//        Class<Number> genericNumberClass = int.class;

        // 通配符 ？来表示"任何事物"
        Class<?> intClass = int.class;
        intClass = double.class;

        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}

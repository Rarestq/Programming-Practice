package com.rarestzhou.bookonjava.advance.references;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 1:42 PM
 * @description: 要将克隆能力添加到自己的类中，你需要绕点弯路
 */
public class AddingClone {

    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = x.clone();
        x2.increment();
        // x = 10, x2 = 11
        System.out.println(
                "x = " + x + ", x2 = " + x2);
        // Anything inherited is also cloneable
        Int3 x3 = new Int3(7);
        x3 = (Int3) x3.clone();
        ArrayList<Int2> v = IntStream.range(0, 10)
                .mapToObj(Int2::new)
                .collect(Collectors.toCollection(ArrayList::new));
        // v: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("v: " + v);
        ArrayList<Int2> v2 =
                (ArrayList<Int2>) v.clone();
        // Now clone each element:
        IntStream.range(0, v.size())
                .forEach(i -> v2.set(i, v.get(i).clone()));
        // Increment all v2's elements:
        v2.forEach(Int2::increment);
        // v2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println("v2: " + v2);
        // See if it changed v's elements:
        System.out.println("v: " + v); // v: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

}

class Int2 implements Cloneable {
    private int i;

    Int2(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    public Int2 clone() {
        try {
            return (Int2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Int3 extends Int2 {
    /**
     * 自动创建了副本
     */
    private int j;

    Int3(int i) {
        super(i);
    }
}

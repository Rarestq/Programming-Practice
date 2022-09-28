package com.rarestzhou.bookonjava.advance.references;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/15 3:02 PM
 * @description: 克隆对象
 */
public class CloneArrayList {

    public static void main(String[] args) {
        ArrayList<Int> v = IntStream.range(0, 10)
                .mapToObj(Int::new)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("v: " + v);

        @SuppressWarnings("unchecked") // 浅拷贝
        ArrayList<Int> v2 = (ArrayList<Int>) v.clone();
        // 对v2中的所有元素进行自增
        v2.forEach(Int::increment);
        // 看是否修改了v中的元素:修改了
        System.out.println("v: " + v);
    }

}

class Int {
    private int i;

    Int(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

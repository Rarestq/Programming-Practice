package com.rarestzhou.bookonjava.basic.strings;

import com.rarestzhou.leetcode_solutions.bookonjavabasic.generics.coffee.Coffee;
import com.rarestzhou.leetcode_solutions.bookonjavabasic.generics.coffee.CoffeeSupplier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 9:39 PM
 * @description: ${description}
 */
public class ArrayListDisplay {

    public static void main(String[] args) {
        List<Coffee> coffees = Stream.generate(new CoffeeSupplier())
                .limit(10)
                .collect(Collectors.toList());
        // [Americano 0, Latte 1, Americano 2, Mocha 3, Mocha 4, Breve 5, Americano 6, Latte 7, Cappuccino 8, Cappuccino 9]
        System.out.println(coffees);
    }
}

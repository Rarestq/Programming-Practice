package com.rarestzhou.bookonjava.basic.reflection;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/21 9:57 PM
 * @description: ${description}
 */

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {

    public static void main(String[] args) {
        // 隐式的向上转型，多态（反射）
        Stream.of(new Circle(), new Square(), new Triangle())
                .forEach(Shape::draw);
    }
}

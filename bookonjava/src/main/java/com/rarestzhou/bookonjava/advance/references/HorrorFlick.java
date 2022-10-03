package com.rarestzhou.bookonjava.advance.references;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/15 3:17 PM
 * @description: 在继承层次结构中的任意一层插入可克隆性
 */
public class HorrorFlick {

    public static void main(String[] args) {
        Person p = new Person();
        Hero h = new Hero();
        Scientist s = new Scientist();
        MadScientist m = new MadScientist();
        // p = (Person) p.clone(); // 编译错误
        // h = (Hero) h.clone(); // 编译错误
        s = s.clone();
        m = (MadScientist) m.clone();
    }
}

class Person {
}

class Hero extends Person {
}

class Scientist extends Person implements Cloneable {

    @Override
    public Scientist clone() {
        try {
            return (Scientist) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MadScientist extends Scientist {
}

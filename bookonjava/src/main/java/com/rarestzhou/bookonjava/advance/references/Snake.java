package com.rarestzhou.bookonjava.advance.references;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/15 3:08 PM
 * @description: 测试克隆，看是否引用的所有目标都被克隆了
 */
public class Snake implements Cloneable {

    private Snake next;
    private char c;

    // i 的值 == 蛇身的段数
    public Snake(int i, char x) {
        c = x;
        if (--i > 0) {
            next = new Snake(i, (char) (x + 1));
        }
    }
    public void increment() {
        c++;
        if (next != null) {
            next.increment();
        }
    }

    @Override public String toString() {
        String s = ":" + c;
        if (next != null) {
            s += next.toString();
        }
        return s;
    }

    @Override public Snake clone() {
        try {
            return (Snake) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Snake s = new Snake(5, 'a');
        // s = :a:b:c:d:e
        System.out.println("s = " + s);
        Snake s2 = s.clone();
        // s2 = :a:b:c:d:e
        System.out.println("s2 = " + s2);
        s.increment();
        // after s.increment, s2 = :a:c:d:e:f， 只有第一段被拷贝了，因此是浅拷贝
        System.out.println("after s.increment, s2 = " + s2);
    }
}

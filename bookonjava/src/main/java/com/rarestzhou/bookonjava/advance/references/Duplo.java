package com.rarestzhou.bookonjava.advance.references;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/13 4:56 PM
 * @description: ${description}
 */
public class Duplo implements Cloneable {

    private int n;

    Duplo(int n) {
        this.n = n;
    }

    @Override
    public Duplo clone() {
        try {
            return (Duplo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getValue() {
        return n;
    }

    public void setValue(int n) {
        this.n = n;
    }

    public void increment() {
        n++;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

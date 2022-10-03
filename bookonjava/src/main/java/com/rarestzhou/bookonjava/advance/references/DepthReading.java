package com.rarestzhou.bookonjava.advance.references;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/15 3:16 PM
 * @description: 克隆组合对象
 */
public class DepthReading implements Cloneable {

    private double depth;

    public DepthReading(double depth) {
        this.depth = depth;
    }

    @Override public DepthReading clone() {
        try {
            return (DepthReading)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public String toString() {
        return String.valueOf(depth);
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}

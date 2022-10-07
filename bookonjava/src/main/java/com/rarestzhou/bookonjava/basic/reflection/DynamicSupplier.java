package com.rarestzhou.bookonjava.basic.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/10/7 8:41 PM
 * @description: ${description}
 */
public class DynamicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override public T get() {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(ID.class))
                .limit(5)
                .forEach(System.out::println);
    }
}

class ID {
    private static long counter;
    private final long id = counter++;

    @Override public String toString() {
        return Long.toString(id);
    }

    // 如果想要调用 getConstructor().newInstance(),就需要提供一个public的无参构造器
    // 因为ID类不是public的，所以ID自动生成的无参构造器不是public的
    public ID() {

    }
}

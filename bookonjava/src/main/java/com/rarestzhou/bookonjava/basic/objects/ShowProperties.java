package com.rarestzhou.bookonjava.basic.objects;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 8:47 PM
 * @description:
 */
public class ShowProperties {

    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
}

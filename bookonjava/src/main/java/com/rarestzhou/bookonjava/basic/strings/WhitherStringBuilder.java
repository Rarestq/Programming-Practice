package com.rarestzhou.bookonjava.basic.strings;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 9:04 PM
 * @description: ${description}
 */
public class WhitherStringBuilder {

    public String implicit(String[] fields) {
        String result = "";
        for (String field : fields) {
            result += field;
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (String field : fields) {
            result.append(field);
        }
        return result.toString();
    }
}

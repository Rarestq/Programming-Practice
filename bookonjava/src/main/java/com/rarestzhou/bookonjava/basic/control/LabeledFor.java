package com.rarestzhou.bookonjava.basic.control;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/10/18 10:45 AM
 * @description: for 循环里带标签的 break 和带标签的 continue
 */
public class LabeledFor {

    public static void main(String[] args) {
        int i = 0;
        outer: // 此处不能有语句
        for (; true; ) {
            inner: // 此处不能有语句
            for (; i < 10; i++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    // 否则 i 不会递增
                    i++;
                    // break 会导致递增表达式被跳过(i++)
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    // 否则 i 不会递增
                    i++;
                    continue outer;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}

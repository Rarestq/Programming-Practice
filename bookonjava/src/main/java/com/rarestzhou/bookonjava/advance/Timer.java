package com.rarestzhou.bookonjava.advance;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/19 1:55 PM
 * @description: ${description}
 */
public class Timer {

    private long start = System.nanoTime();

    public long duration() {
        return NANOSECONDS.toMillis(
                System.nanoTime() - start);
    }

    public static long duration(Runnable test) {
        Timer timer = new Timer();
        test.run();
        return timer.duration();
    }
}

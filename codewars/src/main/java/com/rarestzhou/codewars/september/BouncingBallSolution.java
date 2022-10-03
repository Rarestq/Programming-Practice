package com.rarestzhou.codewars.september;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/29 9:09 PM
 * @description: https://www.codewars.com/kata/5544c7a5cb454edb3c000047/train/java
 * <p>
 * A child is playing with a ball on the nth floor of a tall building. The height of this floor,
 * h, is known.
 * <p>
 * He drops the ball out of the window. The ball bounces (for example), to two-thirds of its height
 * (a bounce of 0.66).
 * <p>
 * His mother looks out of a window 1.5 meters from the ground.
 * <p>
 * How many times will the mother see the ball pass in front of her window (including when it's
 * falling and bouncing?
 * <p>
 * Three conditions must be met for a valid experiment:
 * 1.Float parameter "h" in meters must be greater than 0
 * 2.Float parameter "bounce" must be greater than 0 and less than 1
 * 3.Float parameter "window" must be less than h.
 * If all three conditions above are fulfilled, return a positive integer, otherwise return -1.
 * <p>
 * Note:
 * The ball can only be seen if the height of the rebounding ball is strictly greater than the
 * window parameter.
 * <p>
 * Examples:
 * 1. h = 3, bounce = 0.66, window = 1.5, result is 3
 * <p>
 * 2. h = 3, bounce = 1, window = 1.5, result is -1
 * <p>
 * (Condition 2) not fulfilled).
 */
public class BouncingBallSolution {

    public static int bouncingBall(double h, double bounce, double window) {
        // your code

        // param check
        if (h <= 0 || bounce <= 0 || bounce >= 1 || window >= h) {
            return -1;
        }
        // the height of bounce
        double bounceHeight = h * bounce;
        int count = 1;
        while (bounceHeight > window) {
            // fall & bounce
            count += 2;
            bounceHeight = bounceHeight * bounce;
        }
        return count;
    }

    public static int bouncingBallRecursiveVersion(double h, double bounce, double window) {
        if (h <= 0 || bounce <= 0 || bounce >= 1 || window >= h) {
            return -1;
        }
        return 2 + bouncingBallRecursiveVersion(h * bounce, bounce, window);
    }

    public static void main(String[] args) {
        System.out.println(bouncingBall(3.0, 0.66, 1.5) ==
                bouncingBallRecursiveVersion(3.0, 0.66, 1.5));

        System.out.println(bouncingBall(30.0, 0.66, 1.5) ==
                bouncingBallRecursiveVersion(30.0, 0.66, 1.5));
    }
}

package com.rarestzhou.codewars.september;

import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/9/24 11:26 PM
 * @description: ${description}
 */
public class SmallestIntegerFinder {

    public static void main(String[] args) {
        int[] nums = new int[]{34, 15, 88, 2};
        int minNum = IntStream.of(nums).min().getAsInt();
        System.out.println(minNum);
//        insertionSort(nums, nums.length);
//        System.out.println(nums[0]);
    }


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }
}

package com.example.springdemo.LeetCode;

/**
 * 二分查找代码
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int targe = 10;
        int i = binarySearch(array, targe);
        System.out.println(i);
    }

    public static int binarySearch(int[] a, int i) {
        int l = 0;
        int r = a.length-1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] == i) {
                return m;
            } else if (a[m] < i) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}

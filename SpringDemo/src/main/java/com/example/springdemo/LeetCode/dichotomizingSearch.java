package com.example.springdemo.LeetCode;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class dichotomizingSearch {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3 };
        int target = 4;
        int i = search(nums, target);
        System.out.println(i);
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length / 2;
        int l = nums[left];
        int r = nums[right];
        if (target > r) {
        }
        return -1;
    }
}

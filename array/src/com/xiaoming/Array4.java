package com.xiaoming;

import java.util.Arrays;

public class Array4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares1(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares1(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(sortedSquares3(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares3(new int[]{-7, -3, 2, 3, 11})));
    }

    // 暴力法 时间复杂度是 O(n + nlogn)， 可以说是O(nlogn)的时间复杂度
    public static int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 双指针 时间复杂度为O(n) 循环新数组
    public static int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = nums.length - 1;
        for (int k = result.length - 1; k >= 0; k--) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                result[k] = nums[j] * nums[j];
                j--;
            } else {
                result[k] = nums[i] * nums[i];
                i++;
            }
        }
        return result;
    }

    // 双指针 循环左右指针
    public static int[] sortedSquares3(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left++];
            } else {
                result[index--] = nums[right] * nums[right--];
            }
        }
        return result;
    }
}

package com.xiaoming;

public class Array3 {
    public static void main(String[] args) {
        System.out.println(removeElement1(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement1(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println(removeElement2(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement2(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    //暴力法 时间复杂度是O(n^2)
    public static int removeElement1(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                /*for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }*/
                length--;
                i--;// 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
            }
        }
        return length;
    }

    //快慢指针 时间复杂度是O(n) 空间复杂度：O(1)
    public static int removeElement2(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (val != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}

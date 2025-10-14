package com.xiaoming;

public class Array5 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    //滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE, start = 0, sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum -= nums[start++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}

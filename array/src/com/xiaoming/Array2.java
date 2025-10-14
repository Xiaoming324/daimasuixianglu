package com.xiaoming;

public class Array2 {
    public static void main(String[] args) {
        System.out.println(search1(new int[]{-1, 0, 3, 5, 9}, 9));
        System.out.println(search1(new int[]{-1, 0, 3, 5, 9}, 2));
        System.out.println(search2(new int[]{-1, 0, 3, 5, 9}, 9));
        System.out.println(search2(new int[]{-1, 0, 3, 5, 9}, 2));
    }


    // 区间的定义 [] [) 会影响while条件和循环的写法
    // []
    public static int search1(int[] nums, int target) {
        // 避免当 target 小于nums[0] 或 大于nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1; // []右边界是nums索引的最大值
        while (left <= right) { // [] =是一个合法区间
            int middle = left + (right - left) / 2; // 防止(left+right)超过int的最大值
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        // 未找到目标值
        return -1;
    }

    // [)
    public static int search2(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length; // [)右边界是nums的长度(索引最大值+1)
        while (left < right) { // [) =不是一个合法区间
            int middle = left + (right - left) / 2; // 防止(left+right)超过int的最大值
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }
}

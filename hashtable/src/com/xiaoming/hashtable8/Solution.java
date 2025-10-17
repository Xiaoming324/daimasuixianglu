package com.xiaoming.hashtable8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    // 哈希法做的话 去重的细节太多了 很难想周全
    // 双指针法
    // 本题采用双指针法一定要排序，一旦排序之后原数组的索引就被改变了。
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            // 这么写就是当前使用 nums[i]，我们判断前一位是不是一样的元素，在看 {-1, -1 ,2} 这组数据，当遍历到 第一个 -1 的时候，只要前一位没有-1，那么 {-1, -1 ,2} 这组数据一样可以收录到 结果集里。

            // 去重a
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    // 保证left < right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // 找到答案时，双指针同时收缩
                    // 因为排序了 只right-- 必<0 只left++ 必>0
                    // 如果不做 right-- 和 left++ 会无限循环存找到的这个list
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}

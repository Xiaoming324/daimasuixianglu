package com.xiaoming.hashtable6;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-1, -2}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.get(sum) == null ? 1 : map.get(sum) + 1);
                // map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int target = 0 - i - j;
                if (map.containsKey(target)) count += map.get(target);
                // count += map.getOrDefault(target, 0);
            }
        }
        return count;
    }
}

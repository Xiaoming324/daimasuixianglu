package com.xiaoming.hashtable5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum3(null, 9)));
    }

    //暴力法 O(n^2)
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    //需要一个集合来存放我们遍历过的元素，然后在遍历数组的时候去询问这个集合，某元素是否遍历过，也就是 是否出现在这个集合。
    //HashMap 通过以下机制保证平均O(1)的查找效率：
    //哈希函数将键映射到数组索引
    //直接通过计算哈希值定位到存储位置
    //无需遍历整个数据结构
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        //mao用来存放遍历过的元素！！！
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static int[] twoSum3(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }
}

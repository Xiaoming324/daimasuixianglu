package com.xiaoming.hashtable3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> nums1HashSet = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums1) {
            nums1HashSet.add(num);
        }
        for (int num : nums2) {
            if (nums1HashSet.contains(num)) {
                intersection.add(num);
            }
        }
        /**
         * 将 Set<Integer> 转换为 int[] 数组：
         * 1. stream() : Collection 接口的方法，将集合转换为 Stream<Integer>
         * 2. mapToInt(Integer::intValue) :
         *    - 中间操作，将 Stream<Integer> 转换为 IntStream!!!!!!
         *    - 使用方法引用 Integer::intValue，将 Integer 对象拆箱为 int 基本类型
         * 3. toArray() : 终端操作，将 IntStream 转换为 int[] 数组。
         */
        return intersection.stream().mapToInt(Integer::intValue).toArray();

        //方法2：另外申请一个数组存放setRes中的元素,最后返回数组
        /*int[] arr = new int[resSet.size()];
        int j = 0;
        for(int i : resSet){
            arr[j++] = i;
        }
        return arr;*/
    }

    //leetcode改成数组里的数值会小于1000，用数组来做比较合适
    public static int[] intersection2(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1005];
        Set<Integer> intersection = new HashSet<>();
        for (int i : nums1) {
            hash1[i] = 1;
        }
        for (int i : nums2) {
            if (hash1[i] == 1) {
                intersection.add(i);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}

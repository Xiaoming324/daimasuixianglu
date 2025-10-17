package com.xiaoming.hashtable7;

public class Solution {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aba"));
    }

    //在本题的情况下，使用map的空间消耗要比数组大一些的，因为map要维护红黑树或者哈希表，而且还要做哈希函数，是费时的！数据量大的话就能体现出来差别了。 所以数组更加简单直接有效！
    //时间复杂度: O(m+n)，其中m表示ransomNote的长度，n表示magazine的长度
    //空间复杂度: O(1)
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] map = new int[26];
        /*for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }*/
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            map[ransomNote.charAt(i) - 'a'] -= 1;
        }
        for (int num : map) {
            if (num < 0) return false;
        }
        return true;
    }
}

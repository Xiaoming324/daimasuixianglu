package com.xiaoming.hashtable2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isAnagram("asdasd", "adsadsd"));
    }

    //判断两个字符串由相同的字母组成，位置可以不同
    public static boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a']--;
        }
        /*for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }*/
        for (int count : record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

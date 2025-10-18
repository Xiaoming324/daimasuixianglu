package com.xiaoming.string7;

public class String7 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abababa"));
    }

    //字符串如果是由重复子串组成的
    //那么它的最小重复单位就是他的最长相等前后缀不包含的那一部分
    /*
     * 充分条件：如果字符串s是由重复子串组成的，那么它的最长相等前后缀不包含的子串一定是s的最小重复子串。
     * 必要条件：如果字符串s的最长相等前后缀不包含的子串是s的最小重复子串，那么s必然是由重复子串组成的。
     * 推得：当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时，不包含的子串就是s的最小重复子串。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        int[] next = new int[n];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        // Step 2.判断重复子字符串
        if (next[n - 1] > 0 && n % (n - next[n - 1]) == 0) { // 当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时
            return true; // 不包含的子串就是s的最小重复子串
        } else {
            return false;
        }

    }

    //一般库函数实现为 O(m + n)
    //移动匹配
    public static boolean repeatedSubstringPattern1(String s) {
        String t = s + s;
        t = t.substring(1, t.length() - 1);
        return t.contains(s);
    }

}

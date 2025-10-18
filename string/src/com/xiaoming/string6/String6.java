package com.xiaoming.string6;

public class String6 {
    public static void main(String[] args) {
        System.out.println(strStr("cabba", "ab"));
    }

    //时间复杂度: O(n + m)
    //空间复杂度: O(m)
    public static int strStr(String haystack, String needle) {
        int n = needle.length();
        if (n == 0) return 0;

        int m = haystack.length();
        if (m < n) return -1;

        int[] next = new int[n];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i - n + 1;
            }
        }
        return -1;
    }

    // 前缀表
    private static void getNext(int[] next, String s) {
        // 初始化
        // 前后缀不同
        // 前后缀相同
        // next
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

    /**
     * 牺牲空间，换取最直白的暴力法
     * 时间复杂度 O(n * m)
     * 空间 O(n + m)
     */
    public static int strStr1(String haystack, String needle) {
        // 获取 haystack 和 needle 的长度
        int n = haystack.length(), m = needle.length();
        // 将字符串转换为字符数组，方便索引操作
        char[] s = haystack.toCharArray(), p = needle.toCharArray();

        // 遍历 haystack 字符串
        for (int i = 0; i < n - m + 1; i++) {
            // 初始化匹配的指针
            int a = i, b = 0;
            // 循环检查 needle 是否在当前位置开始匹配
            while (b < m && s[a] == p[b]) {
                // 如果当前字符匹配，则移动指针
                a++;
                b++;
            }
            // 如果 b 等于 m，说明 needle 已经完全匹配，返回当前位置 i
            if (b == m) return i;
        }

        // 如果遍历完毕仍未找到匹配的子串，则返回 -1
        return -1;
    }

    /**
     * 基于窗口滑动的算法
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * 注：n为haystack的长度，m为needle的长度
     */
    public int strStr2(String haystack, String needle) {
        int m = needle.length();
        // 当 needle 是空字符串时我们应当返回 0
        if (m == 0) {
            return 0;
        }
        int n = haystack.length();
        if (n < m) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < n - m + 1) {
            // 找到首字母相等
            while (i < n && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
            if (i == n) {// 没有首字母相等的
                return -1;
            }
            // 遍历后续字符，判断是否相等
            i++;
            j++;
            while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {// 找到
                return i - j;
            } else {// 未找到
                i -= j - 1;
                j = 0;
            }
        }
        return -1;
    }
}

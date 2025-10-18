package com.xiaoming.string4;

public class String4 {

    public static void main(String[] args) {
        System.out.println(reverseWords("Hello   World  hi ha  "));
    }

    //移除多余空格
    //将整个字符串反转
    //将每个单词反转
    public static String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private static StringBuilder removeSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') left++;
        while (s.charAt(right) == ' ') right--;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    private static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    //每个字符在内层循环中被检查一次
    //每个字符在 reverseString 中被处理一次
    //所有操作都是线性扫描，没有嵌套的二次循环
    //因此，总的时间复杂度为 O(n)。
    private static void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int space = 1;
        while (left < sb.length()) {
            while (space < sb.length() && sb.charAt(space) != ' ') {
                space++;
            }
            reverseString(sb, left, space - 1);
            left = space + 1;
            space = left + 1;
        }
    }

}

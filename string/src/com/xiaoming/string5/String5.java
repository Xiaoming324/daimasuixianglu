package com.xiaoming.string5;

public class String5 {
    public static void main(String[] args) {
        System.out.println(reverseRight3(3, "12345"));
    }

    public static String reverseRight1(int n, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < s.length() - n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseRight2(int n, String s) {
        String part1 = s.substring(s.length() - n);
        String part2 = s.substring(0, s.length() - n);
        return part1 + part2;
    }

    public static String reverseRight3(int n, String s) {
        int len = s.length();  //获取字符串长度
        char[] chars = s.toCharArray();
        reverseString(chars, 0, len - 1);  //反转整个字符串
        reverseString(chars, 0, n - 1);  //反转前一段字符串，此时的字符串首尾尾是0,n - 1
        reverseString(chars, n, len - 1);  //反转后一段字符串，此时的字符串首尾尾是n,len - 1
        /*
        everseString(chars, 0, len - n - 1);  //反转前一段字符串，此时的字符串首尾是0,len - n - 1
        reverseString(chars, len - n, len - 1);  //反转后一段字符串，此时的字符串首尾是len - n,len - 1
        reverseString(chars, 0, len - 1);  //反转整个字符串
        */
        return new String(chars);
    }


    public static void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = temp;
        }
    }
}

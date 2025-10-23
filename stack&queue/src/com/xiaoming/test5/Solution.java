package com.xiaoming.test5;

class Solution {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    //直接用String来代替栈
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            /*if (sb.isEmpty() || c != sb.charAt(sb.length() - 1)) {
                sb.append(c);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }*/
            if (!sb.isEmpty() && c == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //双指针
    public static String removeDuplicates1(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while (fast < s.length()) {
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);
    }
}

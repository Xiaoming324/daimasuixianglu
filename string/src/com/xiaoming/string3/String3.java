package com.xiaoming.string3;

public class String3 {
    public static void main(String[] args) {
        System.out.println(replaceNumber2("a1b2c3"));
    }

    public static String replaceNumber(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char a : array) {
            if (a >= 'a' && a <= 'z') {
                sb.append(a);
            } else {
                sb.append("number");
            }
        }
        return sb.toString();
    }

    public static String replaceNumber1(String s) {
        int count = 0; // 统计数字的个数
        int sOldSize = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        // 扩充字符串s的大小，也就是每个空格替换成"number"之后的大小
        char[] newS = new char[s.length() + count * 5];
        int sNewSize = newS.length;
        // 将旧字符串的内容填入新数组
        // srcPos: 源数组中的起始位置
        // destPos: 目标数组中的起始位置
        System.arraycopy(s.toCharArray(), 0, newS, 0, sOldSize);
        // 从后先前将空格替换为"number"
        for (int i = sNewSize - 1, j = sOldSize - 1; j < i; j--, i--) {
            if (!Character.isDigit(newS[j])) {
                newS[i] = newS[j];
            } else {
                newS[i] = 'r';
                newS[i - 1] = 'e';
                newS[i - 2] = 'b';
                newS[i - 3] = 'm';
                newS[i - 4] = 'u';
                newS[i - 5] = 'n';
                i -= 5;
            }
        }
        return new String(newS);
    }


    public static String replaceNumber2(String s) {
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                length += 5;
            }
        }

        char[] arr = new char[length];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        // 双指针从后往前！！！
        //
        for (int i = s.length() - 1, j = length - 1; i >= 0; i--) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                arr[j--] = 'r';
                arr[j--] = 'e';
                arr[j--] = 'b';
                arr[j--] = 'm';
                arr[j--] = 'u';
                arr[j--] = 'n';
            } else {
                arr[j--] = arr[i];
            }
        }
        return new String(arr);
    }
}

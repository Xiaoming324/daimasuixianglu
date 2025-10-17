package com.xiaoming.hashtable4;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> sum = new HashSet<>();
        while (n != 1 && !sum.contains(n)) {
            sum.add(n);
            n = getNewNum(n);
        }
        return n == 1;
    }

    public static int getNewNum(int n) {
        int newNum = 0;
        while (n > 0) {
            int temp = n % 10;
            newNum += temp * temp;
            n = n / 10;
        }
        return newNum;
    }

}

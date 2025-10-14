package com.xiaoming;

import java.util.Scanner;

public class Array7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入整数数组Array的长度");
        int n = sc.nextInt();
        int[] array = new int[n];
        int[] sum = new int[n]; // 前缀和

        int presum = 0;
        System.out.println("请输入数组的元素");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            presum += array[i];
            sum[i] = presum;
        }
        boolean isContinued = true;
        while (isContinued) {
            System.out.println("请输入需要计算总和的区间");
            boolean isStartLegal = false;
            int start = -1;
            int end = -1;
            while (!isStartLegal) {
                System.out.println("请输入开始区间");
                start = sc.nextInt();
                if (start >= n || start < 0) {
                    System.out.println("开始区间违法");
                    continue;
                }
                isStartLegal = true;
            }
            boolean isEndLegal = false;
            while (!isEndLegal) {
                System.out.println("请输入结束区间");
                end = sc.nextInt();
                if (end >= n || end < 0 || start > end) {
                    System.out.println("结束区间违法");
                    continue;
                }
                isEndLegal = true;
            }
            int total = 0;
            if (start == 0) {
                total = sum[end];
            } else {
                total = sum[end] - sum[start - 1]; // 使用前缀和来算区间的和 O(1) 比使用循环要好 O(n)
            }

            System.out.println("区间[" + start + "," + end + "]的总和是" + total);

            System.out.println("是否继续？继续输入1，结束输入2");
            int choice = sc.nextInt();
            if (choice == 2) {
                isContinued = false;
            }
        }
        sc.close();
    }


}

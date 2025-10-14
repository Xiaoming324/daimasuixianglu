package com.xiaoming;

import java.util.Arrays;

public class Array6 {
    public static void main(String[] args) {
        int[][] result = generateMatrix(5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    //时间复杂度 O(n^2): 模拟遍历二维矩阵的时间
    //空间复杂度 O(1)
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startX = 0, startY = 0, count = 1;
        for (int loop = 1; loop <= n / 2; loop++) {
            for (int j = startY; j < n - loop; j++) {
                result[startX][j] = count++;
            }
            for (int i = startX; i < n - loop; i++) {
                result[i][n - loop] = count++;
            }
            for (int j = n - loop; j > startY; j--) {
                result[n - loop][j] = count++;
            }
            for (int i = n - loop; i > startX; i--) {
                result[i][startY] = count++;
            }
            startX++;
            startY++;
        }
        if (n % 2 == 1) {
            result[startX][startY] = count;
        }
        return result;
    }

    public static int[][] generateMatrix1(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;  // 每一圈的起始点
        int offset = 1;
        int count = 1;  // 矩阵中需要填写的数字
        int loop = 1; // 记录当前的圈数
        int i, j; // j 代表列, i 代表行;

        while (loop <= n / 2) {

            // 顶部
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // 右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左列
            // 左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;
    }


}

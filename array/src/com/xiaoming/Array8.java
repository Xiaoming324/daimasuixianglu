package com.xiaoming;

import java.util.Scanner;

public class Array8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0;
        int[][] vec = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = scanner.nextInt();
                sum += vec[i][j];
            }
        }

        int count = 0;
        int result = Integer.MAX_VALUE;

        //统计行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += vec[i][j];
                if (j == m - 1) {
                    result = Math.min(result, Math.abs(sum - count - count));
                }
            }
        }

        //统计列
        count = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                count += vec[i][j];
                if (i == n - 1) {
                    result = Math.min(result, Math.abs(sum - count - count));
                }
            }
        }
        
        System.out.println(result);
        scanner.close();
    }


}

package com.example.algorithmcode.hot100;

/**
 * 62的基础上 -> 最小路径和
 * 1、初始化dp[0][0]
 * 2、同样的初始化第一行和第一列的dp初始值，不过要使用dp[i][0] = dp[i-1][0] + dp[i][0] 的形式
 * 3、dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/9 09:56
 **/
public class Problem_64 {

    public static int minPathSum(int[][] grid) {
        int[][] dp  = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        System.out.println("dp[0][0] = " + dp[0][0]);
        for (int i = 1; i < grid.length; i++) {
            // 每次只能向下，初始化第一列向下的所有情况
            dp[i][0] = dp[i-1][0] + grid[i][0];
            System.out.println(dp[i][0]);
        }
        for (int i = 1; i < grid[0].length; i++) {
            // 每次只能向右，初始化第一行向右的所有情况
            dp[0][i] = dp[0][i-1] + grid[0][i];
            System.out.println(dp[0][i]);
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        int res = minPathSum(grid);
        System.out.println(res);

    }

}

package com.example.algorithmcode.hot100;

/**
 * 不同的路径
 * 1、观察题目：机器人只能向右or向下
 * 2、加入f[i][j] 代表机器人到达(i,j)点的最大路径数量
 * 3、那么我们可以初始化第一行和第一列的dp，他们只可能有一种情况，那就是一直向右or一直乡下
 * 4、对于其他点，我们可以找到dp方程来求解，dp[i][j] = dp[i-1][j] + dp[i][j-1] -> 需要注意数组不能越界，故而for循环的时候，从1开始
 * 5、dp[m-1][n-1]就是我们要找的答案，每个dp都说到达当前点的最大路径数量
 *
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/9 09:45
 **/
public class Problem_62 {

    public static int uniquePaths(int m, int n) {
        int[][] dp  = new int[m][n];
        for (int i = 0; i < m; i++) {
            // 每次只能向下，初始化第一列向下的所有情况
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            // 每次只能向右，初始化第一行向右的所有情况
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 6, n = 4;
        int count = uniquePaths(m, n);
        System.out.println(count);
    }

}

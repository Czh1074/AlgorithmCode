package com.example.algorithmcode.hot100;

import java.util.Scanner;

/**
 * 青蛙跳台阶
 * 1、青蛙到达x层的方法 -> 到达x-1层跳1步 + x-2层跳2步
 * 2、所以可以得到 -> dp[x] = dp[x-1] + dp[x-2];
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/16 11:47
 **/
public class Problem_70 {

    public static int climbStairs(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = climbStairs(x);
        System.out.println(count);
    }
}

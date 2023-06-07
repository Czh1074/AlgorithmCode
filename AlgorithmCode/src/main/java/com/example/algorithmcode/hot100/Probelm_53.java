package com.example.algorithmcode.hot100;

/**
 * 找到最大子串和
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/7 20:24
 **/
public class Probelm_53 {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
}

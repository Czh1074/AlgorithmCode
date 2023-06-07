package com.example.algorithmcode.hot100;

/**
 * 跳远
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/7 21:57
 **/
public class Problem_54 {

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int longway = 0; // 维护一个能跳的最远距离
        for (int i = 0; i < length; i++) {
            if(i <= longway) { // 我这个地方在能到达的区域之内
                longway = Math.max(longway, i + nums[i]); // 更新能跳的最远距离
                if(longway >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,4,0,0,2,3,2};
        boolean b = canJump(x);
        System.out.println(b);
    }
}

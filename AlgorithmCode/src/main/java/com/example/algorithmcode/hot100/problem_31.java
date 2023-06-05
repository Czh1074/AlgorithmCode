package com.example.algorithmcode.hot100;

import java.util.Arrays;
import java.util.List;

/**
 * 下一个排列（即找到大于当前排列值的最小值）
 *
 * 思路：1、从后往前找，找到第一个不符合降序的数字（意味着肯定会有一个数比他大）position
 *      2、继续从后往前找，找到第一个大于position位置的数字，这样去替换，替换后的值肯定比当前排列大change
 *      3、但是替换之后的值不一定的最小的，需要将change位置之后的数字进行逆序，得到的数才是最小的
 *
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/4 21:43
 **/
public class problem_31 {

    public static void nextPermutation(int[] nums) {
        if(nums.length == 1) return ;
        int position = nums.length - 1;
        boolean isRight = false;
        // 1、从后往前面找：找到一个不满足逆序非递减的数
        for(int i = nums.length - 1; i >= 1; i--){
            if(nums[i] > nums[i-1]) {
                position = i-1;
                isRight = true;
                break;
            }
        }
        if(isRight == false) {
            // 2、反转整个数组
            int left = 0, right = nums.length -1;
            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }else {
            int change = position;
            // 2、继续从右往左找，找到第一个比nums[position]大的数
            // 3、交换之后，我的这个序列一定是比原来大的，剩下的要做的事情就是反转position之后的数组
            for(int i = nums.length - 1; i >= 0; i--){
                if(nums[i] > nums[position]) {
                    int temp = nums[i];
                    nums[i] = nums[position];
                    nums[position] = temp;
                    change = i;
                    break;
                }
            }
            // 4、反转数组
            int left = position+1, right = nums.length - 1;
            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }


    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        for (int i = 0 ; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

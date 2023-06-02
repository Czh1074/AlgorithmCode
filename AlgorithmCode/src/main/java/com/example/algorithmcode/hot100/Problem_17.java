package com.example.algorithmcode.hot100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 求电话号码对应的字符
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/2 11:26
 **/
public class Problem_17 {

    private static List<String> str = new ArrayList<>(Arrays.asList("abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"));


    public static List<String> letterCombinations(String digits) {

        ArrayList<String> res = new ArrayList<>();

        // 用map设置num对应的字符串索引
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        // 求出digits的字符串划分为字符数组
        char[] num = digits.toCharArray();

        // 使用回溯，而且是没有重复（要有index）
        backtrack(res, num, map, 0, new StringBuffer());

        return res;
    }

    public static void backtrack(ArrayList<String> res, char[] num, HashMap<Character, String> map, int index, StringBuffer str){
        // 1、出口是什么
        if(index == num.length){
            // 说明这个时候已经有达到要求的值可以返回了
            res.add(str.toString());
        } else {
            char now = num[index]; // now代表着当前的数字按键
            String letters = map.get(now); // 通过号码，找到对应的map字母
            for(int i = 0; i < letters.length(); i++){
                // 2、做什么：进来之后，添加字符即可，因为我们在回溯算法中添加了index，不会有重复的情况出现
                str.append(letters.charAt(i));
                backtrack(res, num, map,index+1, str);
                // 3、撤销: 因为相当于index+1是出口，我现在出口添加结果之后，要将index的字符踢出去，去添加新的字符
                str.deleteCharAt(index);
            }
        }
    }




    public static void main(String[] args) {
        String s = "234";
        List<String> strings = letterCombinations(s);
        for(int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }


}

package com.example.algorithmcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成22
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/3 21:18
 **/
public class problem_22 {

    // 组合 -> 回溯法
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public static void backtrack(List<String> result, StringBuilder temp, int left, int right, int n){
        // 这个时候的位置等于可以出于一个序列的位置
        if(temp.length() == n * 2){
            result.add(temp.toString());
            return;
        } else {
            if(left < n){
                temp.append('(');
                backtrack(result, temp, left+1, right, n);
                temp.deleteCharAt(temp.length() - 1);
            }
            if(right < n && left > right){
                temp.append(')');
                backtrack(result, temp, left, right+1, n);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        List<String> strings = generateParenthesis(3);
        System.out.println("总共几条：" + strings.size());
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }



    }
}

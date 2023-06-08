package com.example.algorithmcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/8 16:23
 **/
public class Problem_56 {

    public static int[][] merge(int[][] intervals) {

        // 如果intervals为空的话 -> 新建一个二维数组返回
        if(intervals.length == 0) {
            return new int[0][0];
        }

        // 对二维数组按照第一个数字进行排序
        // 重写排序规则，按照数组中的第一个数字进行生序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // list数组
        List<int[]> res = new ArrayList<>();

        // 得到排序后的新数组intervals，按照升序排序
        for(int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(new int[]{left, right});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }

        }

        return res.toArray(new int[res.size()][]);

    }

    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0][0] = 1;
        intervals[0][1] = 3;
        intervals[1][0] = 2;
        intervals[1][1] = 6;
        intervals[2][0] = 8;
        intervals[2][1] = 10;
        intervals[3][0] = 15;
        intervals[3][1] = 18;

        int[][] list = merge(intervals);

        for(int i = 0; i < list.length; i++) {
            System.out.println(list[i][0] + " " + list[i][1]);
        }


    }
}

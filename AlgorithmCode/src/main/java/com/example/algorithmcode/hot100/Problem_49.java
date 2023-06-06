package com.example.algorithmcode.hot100;



import org.apache.logging.log4j.util.Strings;

import java.util.*;

/**
 * 字母异位词分组
 *
 * 1、首先，str如何相同，肯定会有一样的hash值，用map进行存储
 * 2、如果不一致，那么我们就新建list<String>
 * 3、不论是否一致，都将其添加进入
 *
 * @Author: ChenZhiHui
 * @DateTime: 2023/6/6 21:11
 **/
public class Problem_49 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        // 通过hash表进行处理 -> 第一个String代表排序后的字符串，第二个List代表该String所有的组合
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            // getOrDefault如果存在的话就返回key对应的List，否则新建
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());

    }


    public static void main(String[] args) {
        String[] strs = {"abc","cba","aaa"};
        List<List<String>> lists = groupAnagrams(strs);
        for(int i = 0; i < lists.size(); i++){
            System.out.println(lists.get(i));
        }

    }
}

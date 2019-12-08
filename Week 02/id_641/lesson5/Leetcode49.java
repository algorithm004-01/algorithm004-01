package vip.ruoyun.week2.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class Leetcode49 {

    //第一种方法: 暴力求解,把里面的字符全部排好序,然后比较
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for (String s : strs) {
            char[] resa = s.toCharArray();
            Arrays.sort(resa);
            String keyResa = Arrays.toString(resa);
            List<String> strings = resultMap.get(keyResa);
            if (strings != null) {
                strings.add(s);
            } else {
                strings = new ArrayList<>();
                strings.add(s);
                resultMap.put(keyResa, strings);
            }
        }
        return new ArrayList<>(resultMap.values());
    }

    //需要自己创建数组,然后 分别统计 每个 类型 的数量,最后比较类型的字符串
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        int[] count = new int[26];
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;

            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int value : count) {
                stringBuilder.append("#");
                stringBuilder.append(value);
            }
            String keyResa = stringBuilder.toString();
            List<String> strings = resultMap.get(keyResa);
            if (strings != null) {
                strings.add(s);
            } else {
                strings = new ArrayList<>();
                strings.add(s);
                resultMap.put(keyResa, strings);
            }
        }
        return new ArrayList<>(resultMap.values());
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists.toString());
        lists = groupAnagrams2(strs);
        System.out.println(lists.toString());


    }
}

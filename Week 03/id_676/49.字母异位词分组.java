import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

 /*
 *思路：1.先将字符串进行排序，排序后的字符串相等为字母异位词
 * 2.使用计数法来统计每个字符串字符出现的次数，如果相等那么就是字母异位词
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if  (strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] a = s.toCharArray();             
            Arrays.sort(a);                                 //排序
            String key = String.valueOf(a);      //排序后的字母异位词作为key
            if  (! map.containsKey(key)) {        //向hashmap中添加key
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);                       //向hashmap中相应的key添加对应的元素
        }
        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end
class SolutionOne {
    public List<List<String>> groupAnagrams(String[] strs) {
        if  (strs.length == 0) return new ArrayList<List<String>>();
        Map<String,List<String> > map = new  HashMap<String,List<String>>();
        int[] count = new int[26];
        for (String s : strs) {                //遍历传进来的字符数组中的字符串
            Arrays.fill(count, 0);           //每次循环开始清0计数数组
            for (int i = 0 ; i < s.length() ; i++) {         
                count[s.charAt(i) - 'a'] ++;     
            }
            StringBuilder stringbuilder = new StringBuilder();

            for (int j = 0; j < 26;j++) {
                stringbuilder.append('#');             //用#1#2.....的方式组成key值
                stringbuilder.append(count[j]);
            }
            String key = stringbuilder.toString();
            if (! map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

class SolutionTwo {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

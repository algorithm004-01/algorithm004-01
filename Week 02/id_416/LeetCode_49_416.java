package com.leetcode.week02;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_49_416 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(null == strs && strs.length == 0) {//空数组
            return null;
        }
        Map<String,List<String>> resultMap = new HashMap<String,List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charStr = str.toCharArray();
            Arrays.sort(charStr);
            String sortedStr = String.valueOf(charStr);
            if(!resultMap.containsKey(sortedStr)) {
                resultMap.put(sortedStr,new ArrayList<String>());
            }
            resultMap.get(sortedStr).add(str);//相同字符串的Hash值是一样的，所以相同的Hash值会散列到同一个key上面
        }
        return new ArrayList(resultMap.values()) ;
    }
    //这种方法其实和第一种方法类似，主要是寻找相同key，当做hashMap的键值，然后相同key对应的value是List
    //然后进行add，这里的相同key是通过计数器counter，字母首先是有顺序的，把按照顺序出现的次数都计算出来，那么就是一样的字符串，当做了key
    public List<List<String>> groupAnagrams1(String[] strs) {
        if(null == strs || strs.length == 0) {
            return null;
        }
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i = 0;i< strs.length;i++) {
            int[] counter =null;
            counter = new int[26];
            for(int k = 0;k<strs[i].length();k++){
                counter[strs[i].charAt(k) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<26;j++){
                sb.append("#");
                sb.append(counter[j]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}

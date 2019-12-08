//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //使用int[26]作为key的标识
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String s: strs){
            int[] arr = new int[26];
            for(int i=0;i<s.length();i++){
                arr[s.charAt(i)-'a']++;
            }
            String key = Arrays.toString(arr);
//            List<String> tempList = map.getOrDefault(key,new ArrayList<String>());
//            tempList.add(s);
//            map.put(key,tempList);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

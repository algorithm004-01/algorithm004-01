/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
           char[] strchar = strs[i].toCharArray();
           Arrays.sort(strchar);
           String keyStr = Arrays.toString(strchar);
           if ( !map.containsKey(keyStr)) {
               map.put(keyStr, new ArrayList<String>(Arrays.asList(strs[i])));
           } else {
               map.get(keyStr).add(strs[i]);
               map.put(keyStr, map.get(keyStr));
           } 
        }
        for (Map.Entry<String, List<String>> entry:map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
// @lc code=end


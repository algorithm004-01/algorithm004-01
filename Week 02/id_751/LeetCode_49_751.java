/**
 *给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
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
 */
//暴力求解 567ms 击败 5.01%的同学！优秀
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; ++i) {
            if(strs[i] == null) continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            for (int j = i +1; j < strs.length; ++j) {
                if (isYW(strs[i], strs[j])) {
                    group.add(strs[j]);
                    strs[j] = null;
                }
            }
            res.add(group);
        }
        return res;
    }
    private boolean isYW(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0 ) return false;
        }
        return true;
    }
}
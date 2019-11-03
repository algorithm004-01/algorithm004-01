import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (58.64%)
 * Likes:    198
 * Dislikes: 0
 * Total Accepted:    32.6K
 * Total Submissions: 55.5K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 将每个字符串按照字母顺序排序，这样的话就可以把 eat，tea，ate 都映射到 aet。其他的类似。
        // 时间复杂度：排序的话算作 O(Klog(n))
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s_arr = strs[i].toCharArray();
            // 排序
            Arrays.sort(s_arr);
            // 映射到 key
            String key = String.valueOf(s_arr);
            // 添加到对应的类中
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());

    }
}

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 质数相乘
        // 例如 abc ，就对应 'a' - 'a'， 'b' - 'a'， 'c' - 'a'，即 0, 1, 2，也就是对应素数 2 3
        // 5，然后相乘2*3*5=30，就把 "abc" 映射到了 30。
        // 时间复杂度：O（n * K），K 是字符串的最长长度。

        HashMap<Integer, List<String>> hash = new HashMap<>();
        // 每个字母对应一个质数
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
                103 };
        for (int i = 0; i < strs.length; i++) {
            int key = 1;
            // 累乘得到 key
            for (int j = 0; j < strs[i].length(); j++) {
                key *= prime[strs[i].charAt(j) - 'a'];
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());
    }

}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 哈希
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] num = new int[26];
            // num是出现的次数，从a=0开始
            for (int j = 0; j < strs[i].length(); j++) {
                num[strs[i].charAt(j) - 'a']++;
            }
            // 把num拼接成 key=1#2#0#0#0
            String key = "";
            for (int j = 0; j < num.length; j++) {
                key = key + num[j] + "#";
            }

            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());

    }

}
// @lc code=end

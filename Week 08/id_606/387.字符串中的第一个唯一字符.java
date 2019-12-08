/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (41.50%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    51.6K
 * Total Submissions: 123.3K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] letter = new int[26];//存储各字符出现次数
        for (char c : s.toCharArray())//第一次遍历
            letter[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {//第二次遍历
            if (letter[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;//无解

    }
}
// @lc code=end

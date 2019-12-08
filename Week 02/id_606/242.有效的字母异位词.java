import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (56.14%)
 * Likes:    116
 * Dislikes: 0
 * Total Accepted:    51.4K
 * Total Submissions: 91.3K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start

class Solution1 {
    public boolean isAnagram(String s, String t) {
        //解法：排序。把s和t排序，对比两个字符串是否相等。
        //时间复杂度：O(nlogn)

        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);//array的排序用的是快排，快排的时间复杂度是O(nlogn)
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        //解法：哈希表。计算两个字符串中每个字母的出现次数并进行比较。
        //时间复杂度：O(n)

        if (s.length() != t.length()) {
            return false;
        }

        int[] conter = new int[26];// 字母出现的次数，从0开始
        for (int i = 0; i < s.length(); i++) {
            conter[s.charAt(i) - 'a']++;
            conter[t.charAt(i) - 'a']--;
        }
        for (int count : conter) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }
}

// @lc code=end
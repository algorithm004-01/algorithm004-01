/*
 * @lc app=leetcode.cn id=242 lang=swift
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (56.17%)
 * Likes:    118
 * Dislikes: 0
 * Total Accepted:    52.7K
 * Total Submissions: 93.3K
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
class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        
        func charDict(with str: String) -> [Character: Int] {
            var dict = [Character: Int]()
            str.forEach { (char) in
                dict[char] = dict[char, default: 0] + 1
            }
            return dict
        }
        
        if s.count != t.count {
            return false
        }
        
        return charDict(with: s) == charDict(with: t)
    }
}
// @lc code=end


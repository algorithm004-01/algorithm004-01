/*
 * @lc app=leetcode.cn id=49 lang=swift
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (58.67%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 57K
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
class Solution {
    // 字符排序比较
    // func groupAnagrams(_ strs: [String]) -> [[String]] {
    //     if strs.count == 0 {
    //         return [[String]]()
    //     }
        
    //     // var map = [String: [String]]()
        
    //     // for str in strs {
    //     //     let sortedStr = String(str.sorted())
    //     //     map[sortedStr, default: [String]()].append(str)
    //     // }

    //     let map = [String: [String]](grouping: strs) { (str) -> String in
    //         return String(str.sorted())
    //     }
        
    //     return [[String]](map.values)
    // }

    // 字符数统计比较
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var map = [[Int]: [String]]()
        
        for str in strs {
            var count = [Int](repeating: 0, count: 26)
            
            for char in str {
                let index = Int(char.asciiValue! - Character("a").asciiValue!)
                count[index] += 1
            }
            
            map[count, default: [String]()].append(str)
        }

        return [[String]](map.values)
    }
}
// @lc code=end


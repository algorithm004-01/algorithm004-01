/*
 * @lc app=leetcode.cn id=127 lang=swift
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (37.12%)
 * Likes:    152
 * Dislikes: 0
 * Total Accepted:    13.4K
 * Total Submissions: 35.6K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
class Solution {
    func ladderLength(_ beginWord: String, _ endWord: String, _ wordList: [String]) -> Int {
        var wordList = Set(wordList)
        if !wordList.contains(endWord) {
            return 0
        }
        
        if wordList.contains(beginWord) {
            wordList.remove(beginWord)
        }
        
        var (res, forward, backward) = (2, Set([beginWord]), Set([endWord]))
        let letters = "abcdefghijklmnopqrstuvwxyz"
        let length = endWord.count
        
        while !forward.isEmpty {
            if forward.count > backward.count {
                (forward, backward) = (backward, forward) //从小集合开始遍历
            }
            
            var cur: Set<String> = Set() //相当于层次序遍历中的新一层
            
            for word in forward {
                
                for idx in 0..<length {
//                    var index = word.index(word.startIndex, offsetBy: idx)
//                    let before = word[..<index]
//                    index  = word.index(index, offsetBy: 1)
//                    let after = word[index...]

                    var chars = Array(word)
                    
                    for letter in letters {
//                        let temp = String(before) + String(letter) + String(after)
                        chars[idx] = letter
                        let temp = String(chars)

                        if backward.contains(temp) {
                            return res
                        }
                        if wordList.contains(temp) {
                            cur.insert(temp)
                            wordList.remove(temp) //这里将与forward中单词只差一个字母的有效单词加入，因为求最短距离，所以已达到的都删除，避免重复访问
                        }
                    }
                }
            }
            
            res += 1
            forward = cur
        }
        
        return 0
    }
}
// @lc code=end


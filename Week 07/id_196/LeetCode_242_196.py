#给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
#
# 示例 1: 
#
# 输入: s = "anagram", t = "nagaram"
#输出: true
# 
#
# 示例 2: 
#
# 输入: s = "rat", t = "car"
#输出: false 
#
# 说明: 
#你可以假设字符串只包含小写字母。 
#
# 进阶: 
#如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
# Related Topics 排序 哈希表



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def isAnagram(self, s: str, t: str) -> bool:
        # 定义默认布尔值参与后续运算
        result = True
        # 利用 Python 数据结构 set 去重去序
        set_tmp = set(s)
        # 先判断组成字符串的各个字符元素是否一致
        if set_tmp == set(t):
            for i in set_tmp:
                # 利用逻辑运算符判断各个字符元素的数量一致，均为 True 才输出 True
                result = result and (s.count(i) == t.count(i))
        else:
            result = False
        return (result)



#leetcode submit region end(Prohibit modification and deletion)

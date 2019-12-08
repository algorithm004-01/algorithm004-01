# 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
#
# 示例 1: 
#
# 输入: 1
# 输出: true
# 解释: 20 = 1
#
# 示例 2: 
#
# 输入: 16
# 输出: true
# 解释: 24 = 16
#
# 示例 3: 
#
# 输入: 218
# 输出: false
# Related Topics 位运算 数学

"""
1 不断除二
2 位运算
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 0: return False
        while n % 2 == 0:
            n //= 2
        return n == 1


class Solution2(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n > 0 and n & (n - 1) == 0

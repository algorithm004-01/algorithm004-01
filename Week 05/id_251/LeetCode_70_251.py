# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
#
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
#
# 注意：给定 n 是一个正整数。 
#
# 示例 1： 
#
# 输入： 2
# 输出： 2
# 解释： 有两种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶
# 2.  2 阶
#
# 示例 2： 
#
# 输入： 3
# 输出： 3
# 解释： 有三种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶 + 1 阶
# 2.  1 阶 + 2 阶
# 3.  2 阶 + 1 阶
# 
# Related Topics 动态规划

"""
1 朴素递归 (1) 递归终止条件 f(1) = 1, f(2) = 2; （2） 递归公式 f(n) = f(n - 1) + f(n - 2)
    时间空间O(2^n)
2 递推公式 时间(1) 空间O(n) DP
3 递归 + 记忆化 空间时间O(n)
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """

    # 1 朴素递归
    def simple_recursion(self, n):
        if n == 1:
            return 1
        if n == 2:
            return 2
        return self.simple_recursion(n - 1) + self.simple_recursion(n - 2)

    # 2 递推 DP
    def iteration(self, n):
        if n == 1:
            return 1
        first, second = 1, 2
        for _ in range(2, n):
            second, first = first + second, second
        return second

    # 2 递推 DP list DP:方程 F(N) = F(N-1) + F(N-2)
    def iteration_DP(self, n):
        if n == 1:
            return 1
        if n == 2:
            return 2
        dp = [1, 2] + [0] * (n - 2)
        for i in range(2, n):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[-1]

    # 斐波那契
    def iteration1(self, n):
        a, b = 0, 1
        for _ in range(n):
            b, a = a + b, b
        return b

    # 3 递归 + 记忆化
    def __init__(self):
        self.dic = {1: 1, 2: 2}

    def memorization_recursion(self, n):
        if n not in self.dic:
            self.dic[n] = self.memorization_recursion(n - 1) + self.memorization_recursion(n - 2)
        return self.dic[n]

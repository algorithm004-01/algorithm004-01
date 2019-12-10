# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
#
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
#
# 问总共有多少条不同的路径？ 
#
# 
#
# 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
#
# 说明：m 和 n 的值均不超过 100。 
#
# 示例 1: 
#
# 输入: m = 3, n = 2
# 输出: 3
# 解释:
# 从左上角开始，总共有 3 条路径可以到达右下角。
# 1. 向右 -> 向右 -> 向下
# 2. 向右 -> 向下 -> 向右
# 3. 向下 -> 向右 -> 向右
# 
#
# 示例 2: 
#
# 输入: m = 7, n = 3
# 输出: 28
# Related Topics 数组 动态规划

"""
1、 暴力递归 2^(m + n) 超时
2、 递归记忆化 O(m * n), 空间O(m * n)
3、 DP O(m * n), 空间O(m * n)
4、 DP 优化 O(m * n), 空间O(m) or O(n)

"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m == 1 or n == 1:
            return 1

        return self.uniquePaths(m - 1, n) + self.uniquePaths(m, n - 1)


dic = {}
class Solution2(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m == 1 or n == 1:
            return 1
        if (m, n) not in dic:
            dic[(m, n)] = self.uniquePaths(m - 1, n) + self.uniquePaths(m, n - 1)

        return dic[(m, n)]


class Solution3(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        """
        DP:
        a. 重复性 problem(i, j) = sub(i - 1, j) + sub(i, j - 1)
        b. 定义状态数组 f[i, j]
        c. DP方程 dp[i, j] = dp[i - 1, j] + dp[i, j - 1]
        """
        dp = [[1 for _ in range(n)] for _ in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]

# dp 优化1
class Solution4(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        pre = [1] * n
        cur = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                cur[j] = pre[j] + cur[j - 1]
            pre = cur[:]
        return cur[-1]

# dp 优化2
class Solution5(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        cur = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                cur[j] += cur[j - 1]
        return cur[-1]


if __name__ == '__main__':
    s = Solution()
    print(s.uniquePaths(2, 3))
    print(s.uniquePaths(3, 2))
    print(s.uniquePaths(7, 3))
    s = Solution2()
    print(s.uniquePaths(2, 3))
    print(s.uniquePaths(3, 2))
    print(s.uniquePaths(7, 3))
    print(s.uniquePaths(28, 14))
    s = Solution3()
    print(s.uniquePaths(2, 3))
    print(s.uniquePaths(3, 2))
    print(s.uniquePaths(7, 3))
    print(s.uniquePaths(28, 14))
    s = Solution4()
    print(s.uniquePaths(2, 3))
    print(s.uniquePaths(3, 2))
    print(s.uniquePaths(7, 3))
    print(s.uniquePaths(28, 14))

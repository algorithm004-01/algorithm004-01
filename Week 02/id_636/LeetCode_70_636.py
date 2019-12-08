'''
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

    注意：给定 n 是一个正整数。

    示例 1：

    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
    1.  1 阶 + 1 阶
    2.  2 阶
    示例 2：

    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶 + 1 阶
    2.  1 阶 + 2 阶
    3.  2 阶 + 1 阶

    链接：https://leetcode-cn.com/problems/climbing-stairs
'''


class Solution:
    def climbStairs(self, n: int) -> int:
        # check the n
        if n <= 2:
            return n

        num1, num2, num3 = 1, 2, 0
        for index in range(3, n + 1):
            num3 = num1 + num2
            num1 = num2
            num2 = num3

        return num3

if __name__ == '__main__':
    s = Solution()
    print("res: ", s.climbStairs(5))
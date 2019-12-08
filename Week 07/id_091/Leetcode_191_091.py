class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            ##把 n 与 1 进行与运算，将得到 n 的最低位数字。因此可以取出最低位数，再将 n 右移一位。循环此步骤，直到 n 等于零
            count += n & 1
            n >>= 1
        return count

    def hammingWeight1(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n:
            res = n % 2
            if res == 1:
                count += 1
            n //= 2
        return count


if __name__ == "__main__":
    solution = Solution()
    res = solution.hammingWeight(7)
    res1 = solution.hammingWeight1(7)
    print(res)
    print(res1)

'''
counting-bits_338

给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:
输入: 2
输出: [0,1,1]
'''

def countBits_1(num):
    # dp问题: dp[i] = dp[i>>1] + (i&1).
    # i>>1代表前一个二进制位的次数,
    # i&1代表i的末尾是否为1
    dp = [0]
    for i in range(1, num+1):
        dp.append(dp[i>>1] + (i&1))
    return dp


def countBits_2(num):
    bits = [0]
    for i in range(1, num+1):
        bits.append(bits[i&(i-1)]+1)
    return bits
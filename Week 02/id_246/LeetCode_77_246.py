'''
combinations_77

给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
'''

#回溯
def combine_1(n,k):
    def backtrack(first=1, curr=[]):
        if len(curr) == k:
            output.append(curr[:])
        for i in range(first, n+1):
            curr.append(i)
            backtrack(i+1, curr)
            curr.pop()
    output = []
    backtrack()
    return output


#递归
def combine_2(n,k):
    if k == 0:
        return [[]]
    return [pre + [i] for i in range(k, n+1) for pre in combine_2(i-1, k-1)]
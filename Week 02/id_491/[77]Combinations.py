#Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 
#
# Example: 
#
# 
#Input: n = 4, k = 2
#Output:
#[
#  [2,4],
#  [3,4],
#  [2,3],
#  [1,2],
#  [1,3],
#  [1,4],
#]
# 
# Related Topics Backtracking



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        res = []

        def backtrack(start=1, curr=[]):
            if len(curr) == k:
                res.append(curr[:])
                return
            for i in range(start, n+1):
                curr.append(i)
                backtrack(i+1, curr)
                curr.pop()

        backtrack()
        return res
        
#leetcode submit region end(Prohibit modification and deletion)

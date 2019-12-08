#给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
#
# 说明：每次只能向下或者向右移动一步。 
#
# 示例: 
#
# 输入:
#[
#  [1,3,1],
#  [1,5,1],
#  [4,2,1]
#]
#输出: 7
#解释: 因为路径 1→3→1→1→1 的总和最小。
# 
# Related Topics 数组 动态规划



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        class Solution:
            def minPathSum(self, grid: [[int]]) -> int:
                for i in range(len(grid)):
                    for j in range(len(grid[0])):
                        if i == j == 0:
                            continue
                        elif i == 0:
                            grid[i][j] = grid[i][j - 1] + grid[i][j]
                        elif j == 0:
                            grid[i][j] = grid[i - 1][j] + grid[i][j]
                        else:
                            grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
                return grid[-1][-1]

      1
#leetcode submit region end(Prohibit modification and deletion)

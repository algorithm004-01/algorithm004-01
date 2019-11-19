# 给定一个二叉树，找出其最大深度。
#
# 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
#
# 说明: 叶子节点是指没有子节点的节点。 
#
# 示例： 
# 给定二叉树 [3,9,20,null,null,15,7]，
#
#     3
#   / \
#  9  20
#    /  \
#   15   7 
#
# 返回它的最大深度 3 。 
# Related Topics 树 深度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
1 递归解法 DFS
2 迭代解法 DFS
"""


class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        """
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1 if root else 0
        """
        return 1 + max(map(self.maxDepth, (root.left, root.right))) if root else 0


class SolutionDFS(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        stack = []
        if root:
            stack.append((1, root))

        depth = 0

        while stack:
            cur_depth, root = stack.pop()
            if root:
                depth = max(depth, cur_depth)
                stack.append((cur_depth + 1, root.left))
                stack.append((cur_depth + 1, root.right))

        return depth

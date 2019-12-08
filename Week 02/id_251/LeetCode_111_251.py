# 给定一个二叉树，找出其最小深度。
#
# 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
#
# 说明: 叶子节点是指没有子节点的节点。 
#
# 示例: 
#
# 给定二叉树 [3,9,20,null,null,15,7], 
#
#     3
#   / \
#  9  20
#    /  \
#   15   7 
#
# 返回它的最小深度 2. 
# Related Topics 树 深度优先搜索 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
1 递归解法
"""


class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        if not root.left:
            return self.minDepth(root.right) + 1
        if not root.right:
            return self.minDepth(root.left) + 1
        return min(map(self.minDepth, (root.left, root.right))) + 1

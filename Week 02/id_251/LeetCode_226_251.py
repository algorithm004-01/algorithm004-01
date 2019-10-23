# 翻转一棵二叉树。
#
# 示例： 
#
# 输入： 
#
#      4
#   /   \
#  2     7
# / \   / \
# 1   3 6   9
#
# 输出： 
#
#      4
#   /   \
#  7     2
# / \   / \
# 9   6 3   1
#
# 备注: 
# 这个问题是受到 Max Howell 的 原问题 启发的 ：
#
# 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
# Related Topics 树


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
1 递归
2 栈 迭代
"""


class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None: return
        root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
        return root

    # 1-2 递归优化
    def invertTree1(self, root):
        if root:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
            return root

    # 2 栈
    def invertTree2(self, root):
        stack = [root]
        while stack:
            node = stack.pop()
            if node:
                node.left, node.right = node.right, node.left
                stack += node.left, node.right
        return root

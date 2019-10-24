# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
#
# 假设一个二叉搜索树具有如下特征： 
#
# 
# 节点的左子树只包含小于当前节点的数。 
# 节点的右子树只包含大于当前节点的数。 
# 所有左子树和右子树自身必须也是二叉搜索树。 
# 
#
# 示例 1: 
#
# 输入:
#    2
#   / \
#  1   3
# 输出: true
# 
#
# 示例 2: 
#
# 输入:
#    5
#   / \
#  1   4
#      / \
#     3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
#      根节点的值为 5 ，但是其右子节点值为 4 。
# 
# Related Topics 树 深度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
1 递归
2 中序遍历
3 stack
"""


class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def valid(node, lower, upper):
            if not node:
                return True
            """
            if not (lower < node.val < upper):
                return False
            if not valid(node.left, lower, node.val):
                return False
            if not valid(node.right, node.val, upper):
                return False
            return True
            """
            return lower < node.val < upper and valid(node.left, lower, node.val) and valid(node.right, node.val, upper)

        return valid(root, float('-inf'), float('inf'))


# 2 中序遍历
class Solution2:
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        order = []
        self.inorderT(root, order)
        return order == sorted(order) and len(order) == len(set(order))

    def inorderT(self, root, order):
        if root:
            self.inorderT(root.left, order)
            order.append(root.val)
            self.inorderT(root.right, order)


# 3 栈
class Solution3:
    def isValidBST(self, root):
        order = []
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            order.append(root.val)
            root = root.right
        return order == sorted(order) and len(order) == len(set(order))

    # 另一种写法
    def isValidBST_(self, root):
        stack = []
        pre = None
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if pre and root.val <= pre.val:
                return False
            pre = root
            root = root.right
        return True

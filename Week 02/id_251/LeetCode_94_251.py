# 给定一个二叉树，返回它的中序 遍历。
#
# 示例: 
#
# 输入: [1,null,2,3]
#   1
#    \
#     2
#    /
#   3
#
# 输出: [1,3,2]
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
# Related Topics 栈 树 哈希表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
1 递归法
"""


class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        vals = []

        def helper(root):
            if root:
                helper(root.left)
                vals.append(root.val)
                helper(root.right)

        helper(root)
        return vals

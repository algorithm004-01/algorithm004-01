# 根据一棵树的前序遍历与中序遍历构造二叉树。
#
# 注意: 
# 你可以假设树中没有重复的元素。
#
# 例如，给出 
#
# 前序遍历 preorder = [3,9,20,15,7]
# 中序遍历 inorder = [9,3,15,20,7]
#
# 返回如下的二叉树： 
#
#     3
#   / \
#  9  20
#    /  \
#   15   7 
# Related Topics 树 深度优先搜索 数组


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


"""
1 递归
"""


class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if inorder:
            ind = inorder.index(preorder.pop(0))
            root = TreeNode(inorder[ind])
            root.left = self.buildTree(preorder, inorder[:ind])
            root.right = self.buildTree(preorder, inorder[ind + 1:])
            return root

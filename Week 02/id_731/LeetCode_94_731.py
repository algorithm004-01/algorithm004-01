# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        def inorderTraversal(root):
            if not root:
                return []
            inorderTraversal(root.left)
            res.append(root.val)
            inorderTraversal(root.right)
        inorderTraversal(root)
        return res

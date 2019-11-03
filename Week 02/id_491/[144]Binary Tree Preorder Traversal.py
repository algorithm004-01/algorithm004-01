#Given a binary tree, return the preorder traversal of its nodes' values. 
#
# Example: 
#
# 
#Input: [1,null,2,3]
#   1
#    \
#     2
#    /
#   3
#
#Output: [1,2,3]
# 
#
# Follow up: Recursive solution is trivial, could you do it iteratively? 
# Related Topics Stack Tree



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        self.helper(root, res)
        return res

    def helper(self, node, res):
        if node:
            res.append(node.val)
            # stack is first in last out
            # so right is before left
            self.helper(node.right, res)
            self.helper(node.left, res)

    # iteration
    def preorderTraversal(self, root):
        res, stack = [], [root]
        while stack:
            node = stack.pop()
            if node:
                res.append(node.val)
                stack.append(node.right)
                stack.append(node.left)
        return res

        
#leetcode submit region end(Prohibit modification and deletion)

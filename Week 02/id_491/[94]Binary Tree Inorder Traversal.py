#Given a binary tree, return the inorder traversal of its nodes' values. 
#
# Example: 
#
# 
#Input: [1,null,2,3]
#   1
#    \
#     2
#    /
#   3
#
#Output: [1,3,2] 
#
# Follow up: Recursive solution is trivial, could you do it iteratively? 
# Related Topics Hash Table Stack Tree



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # recursion
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        self.helper(root, res)
        return res

    def helper(self, node, res):
        if node:
            self.helper(node.left, res)
            res.append(node.val)
            self.helper(node.right, res)

    # iteration
    def inorderTraversal(self, root):
        if not root:
            return []
        res, stack, node = [], [], root
        stack.append(root)
        while stack:
            # go to left most node
            while node and node.left:
                stack.append(node.left)
                node = node.left
            node = stack.pop()
            res.append(node.val)
            # add right of current node into stack
            node = node.right
            if node:
                stack.append(node)
        return res

#leetcode submit region end(Prohibit modification and deletion)

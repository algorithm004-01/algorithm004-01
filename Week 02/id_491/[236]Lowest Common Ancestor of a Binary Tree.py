#Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. 
#
# According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).” 
#
# Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4] 
#
# 
#
# Example 1: 
#
# 
#Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
#Output: 3
#Explanation: The LCA of nodes 5 and 1 is 3.
# 
#
# Example 2: 
#
# 
#Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
#Output: 5
#Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
# 
#
# 
#
# Note: 
#
# 
# All of the nodes' values will be unique. 
# p and q are different and both values will exist in the binary tree. 
# 
# Related Topics Tree



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # recursion
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return None
        if root == p or root == q:
            return root
        left, right = None, None
        # look into left and right side of tree
        if root.left:
            left = self.lowestCommonAncestor(root.left, p, q)
        if root.right:
            right = self.lowestCommonAncestor(root.right, p, q)
        # both p and q found so current root is LCA
        if left and right:
            return root
        # either p or q found on left or right,
        # first found non None node as LCA
        else:
            return left or right
#leetcode submit region end(Prohibit modification and deletion)

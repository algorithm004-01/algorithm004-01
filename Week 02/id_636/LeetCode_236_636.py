# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        '''
        :type root: TreeNode
        :type p:TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        '''
        # 检查是否为空
        if not root:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root

        if root == p or root == q:
            return root

        if left:
            return left

        if right:
            return right

        return None

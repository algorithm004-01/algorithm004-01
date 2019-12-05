# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> list:
        levels = []
        if not root:
            return levels

        def helper(node: TreeNode, level: int):
            if level(levels) == level:
                levels.append([])
                
            levels[level].append(node.val)

            if root.left:
                helper(root.left, level + 1)
            if root.right:
                helper(root.right, level+1)

        helper(root, 0)
        return levels

"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        self.res = [root.val]
        self.dfs(root)
        return self.res
        
    def dfs(self, root):
        # Recursion Terminator
        if root is None:
            return []
        for child in root.children:
            # Process current level
            self.res.append(child.val)
            # Drill down
            self.dfs(child)

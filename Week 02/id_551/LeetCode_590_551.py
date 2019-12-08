"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        self.res = []
        self.dfs(root)
        self.res.append(root.val)
        return self.res
    
    def dfs(self, root):
        # Terminator
        if root is None:
            return []

        for child in root.children:
            # Drill down
            self.dfs(child)
            # Current level
            self.res.append(child.val)

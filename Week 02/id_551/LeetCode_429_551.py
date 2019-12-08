"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root is None:
            return []
        self.res = []
        self.levelTarversal(root, 0)
        return self.res
    
    def levelTarversal(self, root, level):
        # Terminator
        if root is None:
            return
        
        # Current level
        if len(self.res) == level:
            self.res.append([])  
        self.res[level].append(root.val)

        for child in root.children:
            # Drill down
            self.levelTarversal(child, level + 1)

"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        def helper(root):
            if not root:
                return
            i = 0
            while i < len(root.children):
                helper(root.children[i])
                i += 1
            res.append(root.val)
        helper(root)
            
        return res
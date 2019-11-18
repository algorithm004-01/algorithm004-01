#Given an n-ary tree, return the preorder traversal of its nodes' values. 
#
# For example, given a 3-ary tree: 
#
# 
#
# 
#
# 
#
# Return its preorder traversal as: [1,3,5,6,2,4]. 
#
# 
#
# Note: 
#
# Recursive solution is trivial, could you do it iteratively? 
# Related Topics Tree



#leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []
        res, stack = [], [root]
        while stack:
            node = stack.pop()
            res.append(node.val)
            # stack is LIFO, so push right into stack first
            # extend children from right -> left
            stack.extend(node.children[::-1])
        return res
        
#leetcode submit region end(Prohibit modification and deletion)

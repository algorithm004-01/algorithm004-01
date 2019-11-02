#Given an n-ary tree, return the postorder traversal of its nodes' values. 
#
# For example, given a 3-ary tree: 
#
# 
#
# 
#
# 
#
# Return its postorder traversal as: [5,6,3,2,4,1]. 
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
from collections import deque

class Solution(object):
    # traverse tree in pre-order, but use deque to insert result in reverse-order
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []
        deq, stack = deque([]), [root]
        while stack:
            node = stack.pop()
            deq.appendleft(node.val)
            stack.extend(node.children)
        return deq

    def postorder(self, root):
        res = []
        if not root:
            return res
        stack = [root]
        while stack:
            node = stack.pop()
            res.append(node.val)
            stack.extend(node.children)
        # pre order traversal than reverse result
        return res[::-1]

#leetcode submit region end(Prohibit modification and deletion)

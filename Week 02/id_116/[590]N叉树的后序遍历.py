#给定一个 N 叉树，返回其节点值的后序遍历。 
#
# 例如，给定一个 3叉树 : 
#
# 
#
# 
#
# 
#
# 返回其后序遍历: [5,6,3,2,4,1]. 
#
# 
#
# 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树



#leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []
        if root == None: return res

        stack = [root]
        while stack:
            curr = stack.pop()
            res.append(curr.val)
            stack.extend(curr.children)

        return res[::-1]
        
#leetcode submit region end(Prohibit modification and deletion)

#给定一个二叉树，返回它的 前序 遍历。 
#
# 示例: 
#
# 输入: [1,null,2,3]  
#   1
#    \
#     2
#    /
#   3 
#
#输出: [1,2,3]
# 
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
# Related Topics 栈 树



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ret = []
        stack = [root]
        while stack:
            node = stack.pop()
            if node:
                ret.append(node.val)
                stack.append(node.right)
                stack.append(node.left)
        return ret

        
#leetcode submit region end(Prohibit modification and deletion)

# [590. N叉树的后序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)
class Solution:
    def postorder(self, root: 'Node'):
        res = []
        if root == None: return res
        stack = [root]
        
        while stack:
            curr = stack.pop()
            res.append(curr.val)
            stack.extend(curr.children)
            print(stack)
       
            
        return res[::-1]


# 前序排列后的倒序输出
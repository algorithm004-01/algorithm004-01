# [236. 二叉树的最近公共祖先 - 力扣（LeetCode）](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 递归
class Solution:
    def __init__(self):
        self.ans = None
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        :type root:TreeNode
        :type p:TreeNode
        :type q:TreeNode
        :rtype:TreeNode
        """
        def recurse_tree(curr_node):
            if not curr_node:
                return False
            
            left  = recurse_tree(curr_node.left)
            
            right = recurse_tree(curr_node.right)
            
            mid = curr_node == p or curr_node == q
            
            if(mid + left + right >=2):
                self.ans = curr_node
            
            return mid or left or right
        
        recurse_tree(root)
        
        return self.ans

    
    # 父指针迭代 

    def lowestCommonAncestor(self,root,p,q):
        stack = [root]
        
        parent = {root:None}
        
        while p not in parent or q not in parent:
            node = stack.pop()
            
            if node.left:
                parent[node.left] = node
                stack.append(node.left)
                
            if node.right:
                parent[node.right] = node
                stack.append(node.right)
                
            anccestors = set()
            
        while p:
            anccestors.add(p)
            p = parent[p]
            
        while q not in anccestors:
            q = parent[q]
        
        return q
        
    ## 不明觉厉
    def lowestCommonAncestor(self, root, p, q):
        if root in (None, p, q): return root
        left, right = (self.lowestCommonAncestor(kid, p, q)
                   for kid in (root.left, root.right))
        return root if left and right else left or right



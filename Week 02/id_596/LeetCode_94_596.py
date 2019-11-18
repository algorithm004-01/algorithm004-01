#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 递归实现
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     result = []
        
    #     def helper(root: TreeNode):
    #         # terminater
    #         if root == None:
    #             return None
            
    #         # process logic
    #         helper(root.left)
    #         result.append(root.val)
    #         helper(root.right)

    #     helper(root)
    #     return result


    # 迭代实现思路
    # 使用一个栈来记录所有访问的节点以及是否访问过，每次pop出一个结点，如果访问过
    # 就加入结果，如果没有访问过就将这个结点按右中左的顺序压入栈中，并将当前结点
    # 标记为已访问。

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result, stack = [], [(root, False)]
        while stack:
            cur, visited = stack.pop()
            if cur:
                if visited:
                    result.append(cur.val)
                else:
                    stack.append((cur.right, False))
                    stack.append((cur, True))
                    stack.append((cur.left, False))
        return result
        
# @lc code=end


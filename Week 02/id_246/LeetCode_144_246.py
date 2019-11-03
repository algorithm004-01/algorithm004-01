'''
binary tree preorder traversal_144

给定一个二叉树，返回它的 前序 遍历。   中左右

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
'''

from collections import deque

class TreeNode:
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None


class Tree(object):
    def __init__(self):
        self.root = None

    def construct_tree(self,values=None):
        if not values:
            return None
        self.root = TreeNode(values[0])
        queue = deque([self.root])
        leng = len(values)
        nums = 1
        while nums < leng:
            node = queue.popleft()
            if node:
                node.left =TreeNode(values[nums]) if values[nums] else None
                queue.append(node.left)
                if nums + 1 < leng:
                    node.right = TreeNode(values[nums+1]) if values[nums+1] else None
                    queue.append(node.right)
                    nums += 1
                nums += 1

    #递归
    def preorderTraversal_1(self):
        res = []
        def traversal(head):
            if not head:
                return
            res.append(head.val)
            traversal(head.left)
            traversal(head.right)

        traversal(self.root)
        return res

    #迭代
    def preorderTraversal_2(self):
        if self.root is None:
            return []
        stack, output = [self.root, ], []

        while stack:
            self.root = stack.pop()
            if self.root is not None:
                output.append(self.root.val)
                if self.root.right is not None:
                    stack.append(self.root.right)
                if self.root.left is not None:
                    stack.append(self.root.left)
        return output
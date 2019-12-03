'''
binary tree inorder traversal_94

给定一个二叉树，返回它的中序 遍历。 左中右
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,3,2]
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
    def inorderTraversal_1(self):
        res = []
        def traversal(head):
            if not head:
                return
            traversal(head.left)
            res.append(head.val)
            traversal(head.right)

        traversal(self.root)
        return res

    #迭代
    def inorderTraversal_2(self):
        res, stack = [], []
        while True:
            while self.root:
                stack.append(self.root)
                self.root = self.root.left
            if not stack:
                return res
            node = stack.pop()
            res.append(node.val)
            self.root = node.right
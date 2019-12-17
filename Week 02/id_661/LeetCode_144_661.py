#!/usr/bin/env python3.7


class Solution:
    def preorderTraversal(self, root):
        res = []
        self.iterative(root, [root], res)
        return res

    def iterative(self, root, stack, res):
        while stack:
            node = stack.pop()
            if node:
                res.append(node.val)
                stack.append(node.right)
                stack.append(node.left)

    def recursive(self, root, res):
        if root:
            res.append(root.val)
            self.recursive(root.left)
            self.recursive(root.right)

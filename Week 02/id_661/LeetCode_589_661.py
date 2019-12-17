#!/usr/bin/env python3.7


class Solution:
    def preorder(self, root):
        stack = bool(root) * [root]
        res = []
        while stack:
            root = stack.pop()
            res.append(root.val)
            stack += root.children[::-1]
        return res

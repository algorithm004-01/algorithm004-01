#!/usr/bin/env python3.7


class Solution:
    def inorderTraversal(self, root):
        res = []

        def _inorder(root):
            if root:
                _inorder(root.left)
                res.append(root.val)
                _inorder(root.right)
            return res

        return _inorder(root)

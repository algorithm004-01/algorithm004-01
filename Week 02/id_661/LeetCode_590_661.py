#!/usr/bin/env python3.7


class Solution:
    def postorder(self, root):
        res = []
        if not root:
            return res

        def _postorder(root, res):
            for c in root.children:
                _postorder(c, res)
            res.append(root.val)

        _postorder(root, res)
        return res

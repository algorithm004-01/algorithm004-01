'''
n-ary-tree-postorder-traversal_590

给定一个 N 叉树，返回其节点值的后序遍历。 根-右-左
'''

class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

#递归
def postorder_1(root):
    res = []
    if root == None: return res

    def recursion(root, res):
        for child in root.children:
            recursion(child, res)
        res.append(root.val)

    recursion(root, res)
    return res

#迭代
def postorder_2(root):
    if root is None:
        return []
    stack, output = [root, ], []

    while stack:
        root = stack.pop()
        output.append(root.val)
        if root.children:
            for child in root.children:
                stack.append(child)
    return output[::-1]
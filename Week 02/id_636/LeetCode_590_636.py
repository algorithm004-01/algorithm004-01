"""
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3 叉树:
        1
     👆   👆
    3   2   4
  👆👆
5     6

返回其后序遍历: [5,6,3,2,4,1]
"""

class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:
    def postOrder(self, root: 'Node') -> list:
        '''
        :param root: Node
        :return: list
        1：本方案使用的是递归的方法
        '''
        # init res
        res = []
        # if not root, return current res
        if not root:
            return res

        for child in root.children:
            res += self.postOrder(child)
        res += [root.val]

        return res

    def postOrder(self, root: 'Node') -> list:

        '''
        :param root:
        :return: list
        2：stack 的方案
        '''
        # init res
        res = []






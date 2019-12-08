'''
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :
        1
     👆   👆
    3   2   4
  👆👆
5     6

返回其前序遍历: [1,3,5,6,2,4]。
'''

class List(list):
    pass

# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        '''
        :param root: Node
        :return: list
        遍历 root 中所有的 children
        '''
        # init res
        res = []

        if not root:
            return res

        res += [root.val]

        # for loop
        for child in root.children:
            res += self.preorder(child)
        # return res
        return res

    def preOrder(self, root: 'Node') -> List[int]:
        '''
        :param root: Node
        :return: Lisr
        使用 stack 的方法
        '''



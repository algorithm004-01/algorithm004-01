# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: list, inorder: list) -> TreeNode:
        if inorder:
            ind = preorder.index(inorder.pop(0))
            node = TreeNode(preorder[ind])
            node.left = self.buildTree(preorder, ind[0:ind])
            node.right = self.buildTree(preorder, ind[ind+1:])
            return node

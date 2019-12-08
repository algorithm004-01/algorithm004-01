'''
construct binary tree from preorder and inorder traversal_105

根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
'''


#递归
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def buildTree_1(preorder, inorder):
    def helper(in_left = 0, in_right = len(inorder)):
        nonlocal pre_idx
        if in_left == in_right:
            return None
        # pick up pre_idx element as a root
        root_val = preorder[pre_idx]
        root = TreeNode(root_val)
        # root splits inorder list
        # into left and right subtrees
        index = idx_map[root_val]
        pre_idx += 1
        root.left = helper(in_left, index)
        root.right = helper(index+1, in_right)
        return root

    pre_idx = 0
    idx_map = {val:idx for idx, val in enumerate(inorder)}
    return helper()


#
def buildTree_2(preorder, inorder):
    if inorder:
        ind = inorder.index(preorder.pop(0))
        root = TreeNode(inorder[ind])
        root.left = buildTree_2(preorder, inorder[0:ind])
        root.right = buildTree_2(preorder, inorder[ind+1:])
        return root
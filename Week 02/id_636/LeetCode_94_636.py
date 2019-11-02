class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        '''
        root: TreeNode
        list[int]
        '''
        # init
        result = []
        stack = [(1, root)]

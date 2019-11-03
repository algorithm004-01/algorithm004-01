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

        def loop(root: TreeNode):
            if not root:
                return

            loop(root.left)
            result.append(root.val)
            loop(root.right)

        loop(root)

        return result

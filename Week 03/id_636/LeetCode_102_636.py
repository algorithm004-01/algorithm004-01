# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class List(list):
    pass


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # BFS
        # DFS 使用 dfs，需要记录每层的 depth
        # 先用 BFS 做
        res = []

        # def
        def bfs(root: TreeNode, depth: int):
            # check if not root
            if not root:
                return

            # ? init depth's res ?
            if len(res) == depth:
                res.append([])

            # process
            res[depth].append(root.val)

            # left
            bfs(root.left, depth + 1)

            # right
            bfs(root.right, depth + 1)

        bfs(root, 0)

        return res

    def levelOrder_dfs(self, root: TreeNode) -> List[List[int]]:
        # 使用 DFS
        res = []
        


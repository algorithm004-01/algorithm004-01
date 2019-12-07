class BinTreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left, self.right = left, right


class Tree:
    def __init__(self, tree=None):
        self.root = tree


class TraversalTree:
    def __init__(self):
        self.traverse_path = []

    # 前序遍历
    def preorder(self, root):
        if root:
            self.traverse_path.append(root.val)
            self.preorder(root.left)
            self.preorder(root.right)

    # 中序遍历
    def inorder(self, root):
        if root:
            self.inorder(root.left)
            self.traverse_path.append(root.val)
            self.inorder(root.right)

    # 后序遍历
    def postorder(self, root):
        if root:
            self.postorder(root.left)
            self.postorder(root.right)
            self.traverse_path.append(root.val)


if __name__ == '__main__':
    print('-------------空树---------------')
    root = None  # 空树
    print('前序遍历')
    pre = TraversalTree()
    pre.preorder(root)
    print(pre.traverse_path)
    print('中序遍历')
    in_ = TraversalTree()
    in_.inorder(root)
    print(in_.traverse_path)
    print('后序遍历')
    post = TraversalTree()
    post.postorder(root)
    print(post.traverse_path)
    print('-------------二叉搜索树---------------')
    print('         4         \n',
          '   2         5     \n',
          '1     3          7 \n',
          '               6   \n', )
    # 构造一颗树
    root = BinTreeNode(4, BinTreeNode(2, BinTreeNode(1), BinTreeNode(3)),
                       BinTreeNode(5, right=BinTreeNode(7, left=BinTreeNode(6))))
    print('前序遍历')
    pre = TraversalTree()
    pre.preorder(root)
    print(pre.traverse_path)
    print('中序遍历')
    in_ = TraversalTree()
    in_.inorder(root)
    print(in_.traverse_path)
    print('后序遍历')
    post = TraversalTree()
    post.postorder(root)
    print(post.traverse_path)

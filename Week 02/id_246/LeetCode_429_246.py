'''
n-ary tree level-order traversal_429

给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
'''

def levelOrder(root):
    if root is None: return []

    queue, output = [root,], []
    while queue:
        child = []
        node = []
        for item in queue:
            child.append(item.val)
            if item.children: node += item.children
        output.append(child)
        queue = node
    return output

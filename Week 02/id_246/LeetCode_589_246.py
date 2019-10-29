'''
n-ary tree preorder traversal_589

给定一个 N 叉树，返回其节点值的前序遍历。
'''

#递归
def preorder_1(root):
    if root == None: return []

    res = [root.val]
    for child in root.children:
        res.extend(preorder_1(child))

    return res


#迭代
def preorder_2(root):
    if root is None:
        return []
    stack, output = [root, ], []

    while stack:
        root = stack.pop()
        output.append(root.val)
        stack += [child for child in root.children[::-1] if child]
        #if root.children:
            #for child in root.children[::-1]:
                #stack.append(child)
    return output
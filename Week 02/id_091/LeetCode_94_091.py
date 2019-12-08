class Node():

    def __init__(self, data=None, left=None, right=None):
        self._data = data
        self._left = left
        self._right = right


def proOrder(tree):
    if tree == None:
        return False
    print(tree._data)
    proOrder(tree._left)
    proOrder(tree._right)


def posOrder(tree):
    if tree == None:
        return False
    posOrder(tree._left)
    posOrder(tree._right)
    posOrder(tree._data)


def inOrder(tree):
    if tree == None:
        return False
    inOrder(tree._left)
    print(tree._data)
    inOrder(tree._right)


# 层次遍历
def rowOrder(tree):
    queue = []
    queue.append(tree)
    while True:
        if queue == []:
            break
        print(queue[0]._data)
        first_tree = queue[0]
        if first_tree._left != None:
            queue.append(first_tree._left)
        if first_tree._right != None:
            queue.append(first_tree._right)
        queue.remove(first_tree)


if __name__ == '__main__':
    tree = Node('A', Node('B', Node('D'), Node('E')), Node('C', Node('F'), Node('G')))
    proOrder(tree)
# inOrder(tree)
# posOrder(tree)
# rowOrder(tree)

# NOTE


1. 哈希表、映射、集合
拓展内容： Hashmap源代码

2. 树、二叉树、二叉搜索树
拓展内容： 树的代码实现

from collections import deque

class TreeNode:
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None


class Tree(object):
    def __init__(self):
        self.root = None

    def construct_tree(self,values=None):
        if not values:
            return None
        self.root = TreeNode(values[0])
        queue = deque([self.root])
        leng = len(values)
        nums = 1
        while nums < leng:
            node = queue.popleft()
            if node:
                node.left =TreeNode(values[nums]) if values[nums] else None
                queue.append(node.left)
                if nums + 1 < leng:
                    node.right = TreeNode(values[nums+1]) if values[nums+1] else None
                    queue.append(node.right)
                    nums += 1
                nums += 1

3. 泛型递归、 树的递归
拓展内容：优雅计算斐波那契数列， 递归模板

4. 分治、回溯
拓展内容： 牛顿迭代法
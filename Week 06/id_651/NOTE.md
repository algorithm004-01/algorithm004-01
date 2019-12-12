# NOTE

Week 06

1.  字典树, 并查集
    字典树：前缀树,典型应用是统计和排序大量的字符串
    模板
    class Trie(object):
        def __init__(self):
            self.root = {}
            self.end_of_word = '#'
        def insert(self,word):
            node = self.root
            for char in word:
                node = node.setdefault(char, {})
            node[self.end_of_word] = self.end_of_word
        def search(self,word):
            node = self.root
            for char in word:
                if char not in word:
                    return False
                node = node[char]
            return self.end_of_word in node
        def startswith(self, prefix):
            node = self.root
            for char in word:
                if char not in node:
                    return False
                node = node[char]
            return True

    并查集：
    场景： 组团， 配对问题
    模板
    def init(n):
        p = [i for i in range(n)]
    
    def union(self, p, i, j):
        p1 = self.parent(p, i)
        p2 = self.parent(p, j)
        p[p1] = p2

    def parent(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]
        while p[i] != i:
            x = i
            i = p[i]
            p[x] = root
        return root

2. 双向BFS,A*/启发式搜索
    双向BFS : BFS的进阶版本， 从头走到尾，和从尾向头走，相遇的地方即是解
    A*/启发式搜索： 在BFS的基础上， 加上了优先队列的概念（通过估价函数来判断哪些节点是需要优先搜索的）

    DFS模板：
    def DFS(self, tree):
        if tree.root is None:
            return []
        visited, stack = [], [tree.root]
        while stack:
            node = stack.pop()
            vistied.add(node)
            process(node)
            nodes = generate_related_nodes(node)
            stack.push(nodes)
        # other processing work

    BFS模板：
    def BFS(graph, start, end):
        queue = []
        queue.append([start])
        while queue:
            node = queue.pop()
            visited.add(node)
            process(node)
            nodes = generate_related_nodes(node)
            queue.push(nodes)
        # other processing work


3. AVL树和红黑树
    AVL树： 平衡二叉树,有平衡因子/深度差（在-1 0 1范围内则结构是正常的， 如果超出了范围， 则需要做对应的节点调整）
    场景： 在需要查询次数比较多的时候， 更适合用AVL树
    不足： 节点需要存储额外的信息。 调整的频繁

    红黑树：近似平衡二叉树，
    特性： 
        -- 任意节点的子节点的高度差小于两倍
        不能有相邻接的两个红节点
        从任意节点到其他叶子节点所有的路径都包含相同数目的黑色节点
    
    场景： 在需要频繁的插入，删除的操作的时候， 更适合用红黑树
    优点： 调整的没AVL频繁， 存储的信息没AVL多


    基本的旋转操作：
    左旋， 右旋， 左右旋， 右左旋
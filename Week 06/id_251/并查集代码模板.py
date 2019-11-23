class UnionFind:
    def __init__(self, n):
        self.u = list(range(n))

    def union(self, i, j):
        p1 = self.parent(i)
        p2 = self.parent(j)
        self.u[p1] = p2

    def parent(self, i):
        root = i
        while self.u[root] != root:
            root = self.u[root]
        while self.u[i] != i:
            i, self.u[i] = self.u[i], root
        return root

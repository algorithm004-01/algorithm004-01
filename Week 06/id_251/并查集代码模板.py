class UnionFind:
    def __init__(self, n):
        self.u = list(range(n))

    def union(self, i, j):
        p1 = self.find(i)
        p2 = self.find(j)
        self.u[p1] = p2

    def find(self, i):
        root = i
        while self.u[root] != root:
            root = self.u[root]
        while self.u[i] != i:
            self.u[i], i = root, self.u[i]
        return root


if __name__ == '__main__':
    uf = UnionFind(6)
    uf.union(3, 0)
    print(uf.u)
    uf.union(4, 2)
    print(uf.u)
    uf.union(2, 1)
    print(uf.u)
    uf.union(4, 0)
    print(uf.u)
    uf.union(4, 0)
    print(uf.u)

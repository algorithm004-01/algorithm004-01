# 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
#
# 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。 
#
# 示例 1: 
#
# 
# 输入:
# [[1,1,0],
# [1,1,0],
# [0,0,1]]
# 输出: 2
# 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
# 第2个学生自己在一个朋友圈。所以返回2。
# 
#
# 示例 2: 
#
# 
# 输入:
# [[1,1,0],
# [1,1,1],
# [0,1,1]]
# 输出: 1
# 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
# 
#
# 注意： 
#
# 
# N 在[1,200]的范围内。 
# 对于所有学生，有M[i][i] = 1。 
# 如果有M[i][j] = 1，则有M[j][i] = 1。 
# 
# Related Topics 深度优先搜索 并查集

"""
1、DFS
2、BFS
3、UnionFind 并查集
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        N, visited, res = len(M), set(), 0
        for i in range(N):
            if i not in visited:
                self.dfs(M, visited, i)
                res += 1
        return res

    def dfs(self, M, visited, node):
        for i, num in enumerate(M[node]):
            if num and i not in visited:
                visited.add(i)
                self.dfs(M, visited, i)


# bfs
class Solution2(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        N, visited, res = len(M), set(), 0
        for i in range(N):
            if i not in visited:
                queue = [i]
                while queue:
                    p = queue.pop(0)
                    if p not in visited:
                        visited.add(p)
                        queue += [k for k, num in enumerate(M[p]) if num and k not in visited]
                res += 1
        return res


# 并查集
class UnionFind:
    def __init__(self, n):
        self.u = list(range(n))

    def union(self, i, j):
        p1, p2 = self.find(i), self.find(j)
        self.u[p1] = p2

    def find(self, i):
        root = i
        while self.u[root] != root:
            root = self.u[root]
        while self.u[i] != i:
            self.u[i], i = root, self.u[i]
        return root


class Solution3(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        N = len(M)
        uf = UnionFind(N)

        for i in range(N):
            for j in range(N):
                if M[i][j] == 1:
                    uf.union(i, j)
        return len(set([uf.find(i) for i in range(N)]))

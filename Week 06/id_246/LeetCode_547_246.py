'''
friend-circles_547

班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:

输入:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
示例 2:

输入:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
注意：

N 在[1,200]的范围内。
对于所有学生，有M[i][i] = 1。
如果有M[i][j] = 1，则有M[j][i] = 1。
'''


#1
class Solution(object):
    def findCircleNum_1(self, M):
        parent = [-1]*len(M)
        # 为各个集合的深度排序
        rank = dict()
        # 只遍历左下部分
        for i in range(len(M)):
            for j in range(i):
                if M[i][j] == 1:
                    self.union(i,j,parent,rank)
        ans = 0
        for i in parent:
            if i == -1:
                ans += 1
        return ans

    def findRoot(self, num, parent):
        while parent[num] != -1:
            num = parent[num]
        return num

    def union(self, x, y, parent, rank):
        if x == y:
            return
        x = self.findRoot(x, parent)
        y = self.findRoot(y, parent)
        rank_x = rank[x] if x in rank else 0  # 查询集合目前深度
        rank_y = rank[y] if y in rank else 0
        if x == y:
            return
        if rank_x > rank_y:
            parent[y] = x
        elif rank_x < rank_y:
            parent[x] = y
        else:
            parent[x] = y
            rank[y] = 1

#2
import numpy as np

def findCircleNum_2(M):
    return len(set(map(tuple, (np.matrix(M, dtype='bool')**len(M)).A)))


#3
def findCircleNum_3(M):

    n = len(M)
    circles = {x: x for x in range(n)}
    num = n

    def find(node):
        if circles[node] == node: return node
        root = find(circles[node])
        circles[node] = root
        return root

    for i in range(n):
        for j in range(i, n):
            if i != j and M[i][j] == 1 and find(i) != find(j):
                circles[find(i)] = find(j)
    return len([x for x in circles if circles[x] == x])
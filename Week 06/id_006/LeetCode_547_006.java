package com.mrglint.leetcode.week06.solution547;

/**
 * @author luhuancheng
 * @since 2019-11-20 07:56
 */
public class UnionFindSolution {

    private static class UF {
        int count;
        int[] parent;

        public UF(int count) {
            parent = new int[count];
            this.count = count;
            // 初始化并查集
            for (int i = 0; i < count; i++) {
                // 初始化时，每个元素自成一格集合
                parent[i] = i;
            }
        }

        void union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) {
                return;
            }
            parent[iRoot] = jRoot;
            // 维护集合的个数
            count--;
        }

        int find(int i) {
            while (parent[i] != i) {
                // 重新设定父节点指向，路径压缩
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }

    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        UnionFindSolution solution = new UnionFindSolution();
        // 1 0 0 1
        // 0 1 1 0
        // 0 1 1 1
        // 1 0 1 1
        int circleNum = solution.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}});
        System.out.println(circleNum);
    }
}


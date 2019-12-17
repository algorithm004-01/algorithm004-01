import java.util.*;
/**
 * 朋友圈
 */
class Solution {

    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }
        return unionFind.count;
    }

    /**
     * 并查集实现
     */
    static class UnionFind {

        private int count;
        private int[] arr;

        UnionFind(int n) {
            this.count = n;
            this.arr = new int[n];
            while (--n >= 0) arr[n] = n;
        }

        int find(int p) {
            /*while (p != arr[p]) {
                arr[p] = arr[arr[p]];
                p = arr[p];
            }*/
            return arr[p];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            arr[rootP] = rootQ;
            count--;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == rootP) arr[i] = rootQ;
        }
    }
}
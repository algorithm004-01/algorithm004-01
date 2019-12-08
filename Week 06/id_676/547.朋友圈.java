/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */
/*
*思路：1.DFS
*2.并查集（熟练并查集的代码模板）
*/
// @lc code=start
//并查集
class Solution {
    class UnionFind { 
        private int count = 0; 
        private int[] parent; 
        public UnionFind(int n) { 
            count = n; 
            parent = new int[n]; 
            for (int i = 0; i < n; i++) { 
                parent[i] = i;
              }
         } 
        public int find(int p) { 
            while (p != parent[p]) { 
                parent[p] = parent[parent[p]]; 
                   p = parent[p]; 
              }
            return p; 
         }
        public void union(int p, int q) { 
            int rootP = find(p); 
            int rootQ = find(q); 
            if (rootP == rootQ) return; 
            parent[rootP] = rootQ; 
              count--;
         }

         public int count() {
             return count;
         }

    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }

}
// @lc code=end

//DFS
class SolutionOne {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
        
    }
}
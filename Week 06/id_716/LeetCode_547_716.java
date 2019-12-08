import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_547_716 {
    // 1. dfs
    public int findCircleNum1(int[][] M) {
        int circles = 0;
        int[] visited = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                circles++;
            }
        }
        return circles;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    // 2. dfs
    public int findCircleNum2(int[][] M) {
        int circles = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int s = queue.poll();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.offer(j);
                    }
                }
                circles++;
            }
        }

        return circles;
    }

    private int circles;
    // 3. disjoint set
    public int findCircleNum3(int[][] M) {
        circles = M.length;
        int[] parent = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }

        return circles;
    }

    private int find(int[] parent, int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private void union(int[] parent, int p, int q) {
        int rootP = find(parent, p);
        int rootQ = find(parent, q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        circles--;
    }
}
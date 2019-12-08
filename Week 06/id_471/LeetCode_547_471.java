class Solution {

    public int findParent(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return findParent(parent, parent[i]);
    }

    public void union(int[] parent, int i, int j) {
        int x = findParent(parent, i);
        int y = findParent(parent, j);

        if (x != y) {
            parent[x] = y;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int parent[] = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }
}